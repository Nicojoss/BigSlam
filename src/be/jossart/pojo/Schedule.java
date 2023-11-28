package be.jossart.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Schedule implements Serializable{
	//Attributs
	private static final long serialVersionUID = -612195055439435223L;
	private int id;
	private ScheduleType type;
	private int actualRound;
	private List<Match> matches = new ArrayList<>();
	private List<Player> players = new ArrayList<>();
	private Tournament tournament;
	
	//CTOR
	public Schedule(ScheduleType type, int actualRound, Tournament tournament) {
		super();
		this.type = type;
		this.actualRound = actualRound;
		this.tournament = tournament;
		players = initListPlayers();
		matches = initMatches();
	}
	
	//METHODES
	private List<Match> initMatches() {
		if(type.name().equals("GentlementDouble") || type.name().equals("LadiesDouble")) {
			for(int i = 0; i<actualRound; i++) {
				Match match = new Match(actualRound, this);
				matches.add(match);
			}
		}else {
			for(int i = 0; i<actualRound; i++) {
				Match match = new Match(actualRound, this);
				matches.add(match);
			}
		}
		return matches;
	}
	private List<Player> initListPlayers() {
		return Player.findPlayersByScheduleType(type.name());
	}

	public int nbWinningSets() {
		return 0;
	}
	public boolean playNextRound() {
		return false;
	}
	public Player getWinner() {
		return null;
	}
	//GETTERS SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ScheduleType getType() {
		return type;
	}
	public void setType(ScheduleType type) {
		this.type = type;
	}
	public int getActualRound() {
		return actualRound;
	}
	public void setActualRound(int actualRound) {
		this.actualRound = actualRound;
	}
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}
