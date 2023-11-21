package be.jossart.pojo;

import java.io.Serializable;
import java.util.List;

public class Player extends Person implements Serializable{
	//Attributs
	private static final long serialVersionUID = 5072391255607440865L;
	private int rank;
	private String gender;
	private List<Opponent> opponents;
	
	//CTOR
	public Player() {
		super();
	}
	
	public Player(int id, String firstname, String lastname, String nationality, int rank, String gender, List<Opponent> opponents) {
		super(id, firstname, lastname, nationality);
		this.rank = rank;
		this.gender = gender;
		this.opponents = opponents;
	}
	//METHODES
	public boolean create(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public Player find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//GETTERS AND SETTERS
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Opponent> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Opponent> opponents) {
		this.opponents = opponents;
	}
	
	

}
