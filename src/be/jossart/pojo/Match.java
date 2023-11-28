package be.jossart.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	//CTOR
	public Match(int round, Schedule schedule) {
		super();
		this.date = LocalDate.now();
		this.duration = generateDuration(90, 120);
		this.round = round;
		this.schedule = schedule;
		initOpponents();
	}
	
	//Methodes
	public Player getWinner() {
		return null;
	}
	public void play() {
		
	}
	private static int generateDuration(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
	private void initOpponents() {
		for(int i=0 ; i<2; i++) {
			Opponent opponent = new Opponent(this);
			opponents.add(opponent);
		}
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
}
