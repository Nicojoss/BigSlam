package be.jossart.pojo;

import java.io.Serializable;

public class SuperTieBreak extends Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -8773181546331073841L;
	private int id;
	
	//CTOR
	public SuperTieBreak(int id, int scoreOp1, int scoreOp2, Opponent opponent, int id2) {
		super(id, scoreOp1, scoreOp2, opponent);
		id = id2;
	}
	//METHODES
	@Override
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
	
	
	

}
