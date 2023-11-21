package be.jossart.pojo;

import java.io.Serializable;
import java.util.List;

public class Opponent implements Serializable{
	// ATTRIBUTS
	private static final long serialVersionUID = 7200089289272327738L;
	int id;
	private List<Player> players;
	private List<Set> sets;
	
	//CTOR
	public Opponent() {
		super();
	}
	public Opponent(int id, List<Player> players, List<Set> sets) {
		super();
		this.id = id;
		this.players = players;
		this.sets = sets;
	}
	
	//GETTERS SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Set> getSets() {
		return sets;
	}
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
	
	

}
