package be.jossart.pojo;

import java.io.Serializable;
import java.util.List;

import be.jossart.connection.BigSlamConnection;
import be.jossart.dao.CourtDAO;

public class Court implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -5724946250618365735L;
	private int id;
	private String nameCourt;
	private int nbSpectators;
	private boolean covered;
	private Match match;
	
	//CTOR
	public Court() {
		super();
	}
	
	public Court(int id, String nameCourt, int nbSpectators, boolean covered) {
		super();
		this.id = id;
		this.setNameCourt(nameCourt);
		this.nbSpectators = nbSpectators;
		this.covered = covered;	
	}
	public Court(int id, int nbSpectators, boolean covered) {
		super();
		this.id = id;
		this.nbSpectators = nbSpectators;
		this.covered = covered;
	}
	
	//METHODES
	public boolean available() {
		return false;
	}
	public boolean release() {
		return false;
	}
	public static List<Court> getAllCourts() {
		CourtDAO courtDAO = new CourtDAO(BigSlamConnection.getInstance());
		
		List<Court> courts = courtDAO.findAll();
	    
		return courts;
	}
	//GETTERS SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbSpectators() {
		return nbSpectators;
	}
	public void setNbSpectators(int nbSpectators) {
		this.nbSpectators = nbSpectators;
	}
	public boolean isCovered() {
		return covered;
	}
	public void setCovered(boolean covered) {
		this.covered = covered;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}

	public String getNameCourt() {
		return nameCourt;
	}

	public void setNameCourt(String nameCourt) {
		this.nameCourt = nameCourt;
	}
}
