package be.jossart.pojo;

import java.io.Serializable;
import java.util.Random;

public class SuperTieBreak extends Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -8773181546331073841L;
	
	//CTOR
	public SuperTieBreak(int scoreOp1, int scoreOp2, Opponent opponent, Match match) {
		super(match);
		this.scoreOp1 = 0;
		this.scoreOp2 = 0;
	}
	//METHODES
	 @Override
	    public void play() {
	    }
}
