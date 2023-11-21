package be.jossart.pojo;

import java.io.Serializable;
import java.util.List;

public class Schedule implements Serializable{
	//Attributs
	private static final long serialVersionUID = -612195055439435223L;
	private int id;
	private ScheduleType type;
	private int actualRound;
	private List<Match> matches;
	
	//CTOR
	public Schedule() {
		super();
	}
	
	public Schedule(ScheduleType type, int actualRound, List<Match> matches) {
		super();
		this.type = type;
		this.actualRound = actualRound;
		this.matches = matches;
	}

	public Schedule(int id, ScheduleType type, int actualRound, List<Match> matches) {
		super();
		this.id = id;
		this.type = type;
		this.actualRound = actualRound;
		this.matches = matches;
	}
	//METHODES
	//TODO: AJOUTER LA METHODE NbWinningSets()
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
	
	
}
