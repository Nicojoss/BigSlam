package be.jossart.pojo;

import java.io.Serializable;
import java.util.List;

import be.jossart.connection.BigSlamConnection;
import be.jossart.dao.RefereeDAO;

public class Referee extends Person implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = 623324850825415671L;
	private Match match;
	private List<Tournament> tournaments;
	
	//CTOR
	public Referee(int id, String firstname, String lastname, String nationality) {
		super(id, firstname, lastname, nationality);
	}
	public Referee() {
		super();
	}
	//METHODES
	public void available() {
	}
	public void release() {}
	public static List<Referee> getAllReferee() {
		RefereeDAO refereeDAO = new RefereeDAO(BigSlamConnection.getInstance());
		
		List<Referee> referees = refereeDAO.findAll();
	    
	    return referees;
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
