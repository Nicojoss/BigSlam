package be.jossart.pojo;

import java.io.Serializable;

public abstract class Person implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -1537323967801183030L;
	private int id;
	private String firstname;
	private String lastname;
	private String nationality;
	
	//CTOR
	public Person() {
		super();
	}
	public Person(int id, String firstname, String lastname, String nationality) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.nationality = nationality;
	}
	
	//GETTERS SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
