package be.jossart.pojo;

import java.io.Serializable;

public class Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -2406995578434433692L;
	private int id;
	private int scoreOp1;
	private int scoreOp2;
	private Opponent opponent;
	
	//CTOR
	public Set(int id, int scoreOp1, int scoreOp2, Opponent opponent) {
		super();
		this.id = id;
		this.scoreOp1 = scoreOp1;
		this.scoreOp2 = scoreOp2;
		this.opponent = opponent;
	}
	
	public Set(int id, int scoreOp1, int scoreOp2) {
		super();
		this.id = id;
		this.scoreOp1 = scoreOp1;
		this.scoreOp2 = scoreOp2;
	}
	public Set() {
		super();
	}
	
	//METHODES
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
	public int getScoreOp1() {
		return scoreOp1;
	}
	public void setScoreOp1(int scoreOp1) {
		this.scoreOp1 = scoreOp1;
	}
	public int getScoreOp2() {
		return scoreOp2;
	}
	public void setScoreOp2(int scoreOp2) {
		this.scoreOp2 = scoreOp2;
	}
	public Opponent getOpponent() {
		return opponent;
	}
	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}
	
	
	

}
