package be.jossart.pojo;

import java.io.Serializable;

public class Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -2406995578434433692L;
	protected int scoreOp1 = 0;
	protected int scoreOp2 = 0;
	private Opponent opponentWinner = null;
	private Match match;
	
	//CTOR
	public Set(Match match) {
		super();
		this.match = match;
	}
	//METHODES
	public void play() {
		
	}
	
	//GETTERS SETTERS
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
	public Opponent getOpponentWinner() {
		return opponentWinner;
	}
	public void setOpponentWinner(Opponent opponentWinner) {
		this.opponentWinner = opponentWinner;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}

}
