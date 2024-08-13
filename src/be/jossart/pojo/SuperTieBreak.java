package be.jossart.pojo;

import java.io.Serializable;

public class SuperTieBreak extends Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -8773181546331073841L;
	private static final int WINNING_POINTS = 10;
	//CTOR
	public SuperTieBreak(Match match) {
		super(match);
	}
	//METHODES
	@Override
    public void play() {
		int pointsOp1 = 0;
        int pointsOp2 = 0;

        while (Math.abs(pointsOp1 - pointsOp2) < 2 && (pointsOp1 < WINNING_POINTS && pointsOp2 < WINNING_POINTS)) {
            boolean pointForOp1 = Math.random() < 0.5;
            if (pointForOp1) {
                pointsOp1++;
            } else {
                pointsOp2++;
            }
        }
        
        if (pointsOp1 > pointsOp2) {
            setOpponentWinner(getMatch().getOpponents().get(0));
        } else {
            setOpponentWinner(getMatch().getOpponents().get(1));
        } 
    }
}
