package be.jossart.pojo;

import java.io.Serializable;
import java.util.List;

public class Referee extends Person implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = 623324850825415671L;
	private Match match;
	private List<Tournament> tournaments;
	
	//CTOR
	public Referee(int id, String firstname, String lastname, String nationality, Match match, List<Tournament> tournaments) {
		super(id, firstname, lastname, nationality);
		this.match = match;
		this.tournaments = tournaments;
	}
	public Referee() {
		super();
	}
	
	//GETTERS SETTERS
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	public List<Tournament> getTournaments() {
		return tournaments;
	}
	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	

}
