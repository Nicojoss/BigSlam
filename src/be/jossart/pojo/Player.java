package be.jossart.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import be.jossart.connection.BigSlamConnection;
import be.jossart.dao.DAO;
import be.jossart.dao.PlayerDAO;

public class Player extends Person implements Serializable{
	//Attributs
	private static final long serialVersionUID = 5072391255607440865L;
	private int rank;
	private String gender;
	private List<Opponent> opponents = new ArrayList<Opponent>();
	
	//CTOR
	public Player(Opponent opponent) {
		super();
		opponents.add(opponent);
	}
	public Player(int id, String firstname, String lastname, String genderPlayer, String nationality, int rank) {
		super(id, firstname, lastname, nationality);
		this.gender = genderPlayer;
		this.rank = rank;
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
	
	public static Player getPlayerByGender(String typeSchedule) {
		DAO<Player> playerDAO = new PlayerDAO(BigSlamConnection.getInstance());
		
		if(typeSchedule.equals("GentlemenSingle") || typeSchedule.equals("GentlemenDouble") || typeSchedule.equals("M")) {
			return ((PlayerDAO) playerDAO).findByGender("M");
		}else{
			return ((PlayerDAO) playerDAO).findByGender("F");
		}
	}
	
	public static List<Player> findAll(){
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString();
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
	public static List<Player> findPlayersByScheduleType(String scheduleType) {
		DAO<Player> playerDAO = new PlayerDAO(BigSlamConnection.getInstance());

	    if("GentlemenSingle".equals(scheduleType) || "GentlemenDouble".equals(scheduleType) || "M".equals(scheduleType)) {
	        return ((PlayerDAO) playerDAO).findPlayersByGender("M");
	    }else if ("LadiesSingle".equals(scheduleType) || "LadiesDouble".equals(scheduleType) || "F".equals(scheduleType)) {
	        return ((PlayerDAO) playerDAO).findPlayersByGender("F");
	    }else {
	        return playerDAO.findAll();
	    }
	}
}
