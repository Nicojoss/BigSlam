package be.jossart.pojo;

import java.io.Serializable;

public class SuperTieBreak extends Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -8773181546331073841L;
	
	//CTOR
	public SuperTieBreak(int scoreOp1, int scoreOp2, Opponent opponent) {
		super();
	}
	//METHODES
	@Override
    public boolean play() {
        return false;
    }
}
