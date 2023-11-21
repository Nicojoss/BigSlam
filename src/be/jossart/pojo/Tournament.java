package be.jossart.pojo;

import java.io.Serializable;
import java.util.*;

public class Tournament implements Serializable{
	//Attributes
	private static final long serialVersionUID = 7623019250849900526L;
	private int id;
	private String name;
	private List<Court> courts = new ArrayList<Court>();
	private List<Referee> referees;
	private List<Schedule> schedules;
	
	//CTOR
	public Tournament(int id, String name, List<Schedule> schedules) {
		super();
		this.id = id;
		this.name = name;
		this.schedules = schedules;
		initSchedules();
	}

	public Tournament() {
		super();
	}

	//METHODES
	private void initSchedules() {
		//TODO: AJOUTER LES SCHEDULES SELON LE TYPE
        schedules.add(new Schedule());
        schedules.add(new Schedule());
        schedules.add(new Schedule());
        schedules.add(new Schedule());
        schedules.add(new Schedule());
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Court> getCourts() {
		return courts;
	}
	public void setCourts(List<Court> courts) {
		this.courts = courts;
	}
	public List<Referee> getReferees() {
		return referees;
	}
	public void setReferees(List<Referee> referees) {
		this.referees = referees;
	}
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	
}
