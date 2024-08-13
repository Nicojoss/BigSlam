package be.jossart.pojo;

import java.io.Serializable;
import java.util.*;

public class Tournament implements Serializable{
	//Attributes
	private static final long serialVersionUID = 7623019250849900526L;
	private String name;
	private List<Court> courts = new ArrayList<Court>();
	private List<Referee> referees = new ArrayList<Referee>();
	private List<Schedule> schedules;
	
	//CTOR
	public Tournament(String name) {
		super();
		this.name = name;
		initSchedules();
	}

	public Tournament() {
		super();
	}

	//METHODES
	public void initSchedules() {
		schedules = new ArrayList<Schedule>();
		
        schedules.add(new Schedule(ScheduleType.GentlemenSingle, 64, this));
        schedules.add(new Schedule(ScheduleType.LadiesSingle, 64, this));
        schedules.add(new Schedule(ScheduleType.GentlemenDouble, 32, this));
        schedules.add(new Schedule(ScheduleType.LadiesDouble, 32, this));
        schedules.add(new Schedule(ScheduleType.MixedDouble, 64, this));
    }
	public List<Referee> initReferees(){
		return referees = Referee.getAllReferee();
	}
	public List<Court> initCourts() {
		return courts = Court.getAllCourts();
	}
	public void play() {
		for(Schedule s : schedules) {
			s.playNextRound();
			s.setActualRound((s.getActualRound()/2));
		}
	}
	
	//GETTERS SETTERS
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
