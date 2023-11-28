package be.jossart.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opponent implements Serializable{
	// ATTRIBUTS
	private static final long serialVersionUID = 7200089289272327738L;
	private List<Player> players = new ArrayList<>();
	private List<Set> sets;
	
	//CTOR
	public Opponent(Match match) {
		super();
		initPlayers(match);
	}
	
	//Methodes
		private void initPlayers(Match match) {
		    if ("GentlemenSingle".equals(match.getSchedule().getType().name()) || "LadiesSingle".equals(match.getSchedule().getType().name())) {
		        Player player = new Player(this);
		    	Collections.shuffle(match.getSchedule().getPlayers());
		    	
		    	if(match.getSchedule().getPlayers().size() >= 1) {
		    		player = match.getSchedule().getPlayers().get(0);
		    		players.add(player);
		    		match.getSchedule().getPlayers().remove(0);
		    	}
		    } else if ("GentlemenDouble".equals(match.getSchedule().getType().name()) || "LadiesDouble".equals(match.getSchedule().getType().name())) {
		    	Player player1 = new Player(this);
		    	Player player2 = new Player(this);
		    	Collections.shuffle(match.getSchedule().getPlayers());
		    	
		    	if(match.getSchedule().getPlayers().size() >= 2) {
		    		player1 = match.getSchedule().getPlayers().get(0);
		    		player2 = match.getSchedule().getPlayers().get(1);
		    		players.add(player1);
		    		players.add(player2);
		    		match.getSchedule().getPlayers().remove(0);
		    		match.getSchedule().getPlayers().remove(0);
		    	}
		    } else {
		    	Player player1 = new Player(this);
		    	Player player2 = new Player(this);
		    	Collections.shuffle(match.getSchedule().getPlayers());
		    	
		    	if(match.getSchedule().getPlayers().size() >= 2) {
		    		player1 = match.getSchedule().getPlayers().get(0);
		    		player2 = match.getSchedule().getPlayers().get(1);
		    		players.add(player1);
		    		int i = 1;
		    		
		    		if(player1.getGender().equals(player2.getGender())){
		    			while(player2.getGender().equals(player1.getGender())){
			    			i +=1;
			    			player2 = match.getSchedule().getPlayers().get(i);
			   			}
		    			players.add(player2);
		    			match.getSchedule().getPlayers().remove(0);
		    			match.getSchedule().getPlayers().remove(i-1);
		    		}else {
		    			players.add(player2);
		    			match.getSchedule().getPlayers().remove(0);
		    			match.getSchedule().getPlayers().remove(0);
		    			}
		    		}
		    	}
		    }

	//GETTERS SETTERS
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public List<Set> getSets() {
		return sets;
	}
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
}
