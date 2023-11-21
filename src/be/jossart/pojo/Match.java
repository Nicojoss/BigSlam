package be.jossart.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Match implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = 4804782659203218408L;
	int id;
	private LocalDate date;
	private int duration;
	private int round;
	private Court court;
	private Referee referee;
	private List<Set> sets;
	private List<Opponent> opponents;
	
	//CTOR
	public Match() {
		super();
	}
	public Match(int id, LocalDate date, int duration, int round, List<Set> sets,
			List<Opponent> opponents) {
		super();
		this.id = id;
		this.date = date;
		this.duration = duration;
		this.round = round;
		this.sets = sets;
		this.opponents = opponents;
	}
	
	//Methodes
	public Player getWinner() {
		return null;
	}
	public boolean play() {
		return false;
	}
	//GETTERS SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	
	
}
