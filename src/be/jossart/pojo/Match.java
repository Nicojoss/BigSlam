package be.jossart.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import be.jossart.connection.BigSlamConnection;
import be.jossart.dao.DAO;
import be.jossart.dao.MatchDAO;

public class Match implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = 4804782659203218408L;
	private LocalDate date;
	private int duration;
	private int round;
	private Court court;
	private Referee referee;
	private List<Set> sets;
	private List<Opponent> opponents = new ArrayList<>();
	private Schedule schedule;
	private List<Player> winnerPlayer = new ArrayList<>();
	private List<Player> loserPlayer = new ArrayList<>();
	private int setsWonByPlayer1 = 0;
    private int setsWonByPlayer2 = 0;

	//CTOR
	public Match(int round, Schedule schedule) {
		super();
		this.date = LocalDate.now();
		this.duration = generateDuration(90, 120);
		this.round = round;
		this.schedule = schedule;
		this.sets = new ArrayList<>();
		court = initCourt();
		referee = initReferee();
		initOpponents();
	}
	
	//Methodes
	public List<Player> getWinner(int setsWonByPlayer1, int setsWonByPlayer2) {
		if(setsWonByPlayer1 > setsWonByPlayer2) {
			if(isDoublesMatch()) {
				winnerPlayer.add(opponents.get(0).getPlayers().get(0));
				winnerPlayer.add(opponents.get(0).getPlayers().get(1));
				this.schedule.getPlayers().add(opponents.get(0).getPlayers().get(0));
				this.schedule.getPlayers().add(opponents.get(0).getPlayers().get(1));
				loserPlayer.add(opponents.get(1).getPlayers().get(0));
				loserPlayer.add(opponents.get(1).getPlayers().get(1));
			}else {
				winnerPlayer.add(opponents.get(0).getPlayers().get(0));
				this.schedule.getPlayers().add(opponents.get(0).getPlayers().get(0));
				loserPlayer.add(opponents.get(1).getPlayers().get(0));
			}
			
			return winnerPlayer;
		}else {
			if(isDoublesMatch()) {
				winnerPlayer.add(opponents.get(1).getPlayers().get(0));
				winnerPlayer.add(opponents.get(1).getPlayers().get(1));
				this.schedule.getPlayers().add(opponents.get(1).getPlayers().get(0));
				this.schedule.getPlayers().add(opponents.get(1).getPlayers().get(1));
				loserPlayer.add(opponents.get(0).getPlayers().get(0));
				loserPlayer.add(opponents.get(0).getPlayers().get(1));
			}else {
				winnerPlayer.add(opponents.get(1).getPlayers().get(0));
				this.schedule.getPlayers().add(opponents.get(1).getPlayers().get(0));
				loserPlayer.add(opponents.get(0).getPlayers().get(0));
			}
			return winnerPlayer;
		}
	}
	public void play() {
	    int nbrSetsToWin = this.schedule.nbWinningSets();
	    
	    while (setsWonByPlayer1 < nbrSetsToWin && setsWonByPlayer2 < nbrSetsToWin) {
	        Set set = createSet(setsWonByPlayer1, setsWonByPlayer2, nbrSetsToWin);
	        set.play();
	        sets.add(set);

	        if (set.getOpponentWinner() == opponents.get(0)) {
	            setsWonByPlayer1++;
	        } else {
	            setsWonByPlayer2++;
	        }
	    }
	    getWinner(setsWonByPlayer1, setsWonByPlayer2);
	    saveMatchResult(setsWonByPlayer1, setsWonByPlayer2);
	}
	public Set createSet(int setsWonByPlayer1, int setsWonByPlayer2, int nbrSetsToWin) {
	    boolean isDoubles = isDoublesMatch();
	    boolean isFinalSet = sets.size() == (nbrSetsToWin - 1);

	    if (isFinalSet && isDoubles) {
	        return new SuperTieBreak(this);
	    }
	    return new Set(this);
	}
	public boolean isDoublesMatch() {
	    ScheduleType type = schedule.getType();
	    return type == ScheduleType.GentlemenDouble || 
	           type == ScheduleType.LadiesDouble || 
	           type == ScheduleType.MixedDouble;
	}

	public void saveMatchResult(int setsWonByPlayer1, int setsWonByPlayer2) {
		DAO<Match> matchDAO = new MatchDAO(BigSlamConnection.getInstance());
		matchDAO.create(this);
	}
	public static int generateDuration(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
	private void initOpponents() {
		for(int i=0 ; i<2; i++) {
			Opponent opponent = new Opponent(this);
			opponents.add(opponent);
		}
	}
	private Court initCourt() {
		List<Court> courts = Court.getAllCourts();
		Random random = new Random();
	    int randomIndex = random.nextInt(courts.size());
	    
	    return courts.get(randomIndex);
	}
	private Referee initReferee() {
		List<Referee> referees = Referee.getAllReferee();
		Random random = new Random();
	    int randomIndex = random.nextInt(referees.size());
	    
	    return referees.get(randomIndex);
	}
	
	//GETTERS SETTERS
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public Referee getReferee() {
		return referee;
	}
	public void setReferee(Referee referee) {
		this.referee = referee;
	}
	public List<Set> getSets() {
		return sets;
	}
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
	public List<Opponent> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Opponent> opponents) {
		this.opponents = opponents;
	}
	public Court getCourt() {
		return court;
	}
	public void setCourt(Court court) {
		this.court = court;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<Player> getWinnerPlayer() {
		return winnerPlayer;
	}

	public void setWinnerPlayer(List<Player> winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}

	public List<Player> getLoserPlayer() {
		return loserPlayer;
	}

	public void setLoserPlayer(List<Player> loserPlayer) {
		this.loserPlayer = loserPlayer;
	}
	public int getSetsWonByPlayer1() {
		return setsWonByPlayer1;
	}

	public void setSetsWonByPlayer1(int setsWonByPlayer1) {
		this.setsWonByPlayer1 = setsWonByPlayer1;
	}

	public int getSetsWonByPlayer2() {
		return setsWonByPlayer2;
	}

	public void setSetsWonByPlayer2(int setsWonByPlayer2) {
		this.setsWonByPlayer2 = setsWonByPlayer2;
	}
}
