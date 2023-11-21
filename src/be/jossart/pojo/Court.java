package be.jossart.pojo;

import java.io.Serializable;

public class Court implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -5724946250618365735L;
	private int id;
	private int nbSpectators;
	private boolean covered;
	private Match match;
	
	//CTOR
	public Court() {
		super();
	}
	
	public Court(int id, int nbSpectators, boolean covered, Match match) {
		super();
		this.id = id;
		this.nbSpectators = nbSpectators;
		this.covered = covered;
		this.match = match;
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
	

}
