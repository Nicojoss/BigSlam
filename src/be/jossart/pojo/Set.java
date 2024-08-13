package be.jossart.pojo;

import java.io.Serializable;

public class Set implements Serializable{
	//ATTRIBUTS
	private static final long serialVersionUID = -2406995578434433692L;
	private int scoreOp1 = 0;
	private int scoreOp2 = 0;
	private Opponent opponentWinner = null;
	private Match match;
	
	//CTOR
	public Set(Match match) {
		super();
		this.match = match;
	}
	//METHODES
	public void play() {
	    int gamesOp1 = 0;
	    int gamesOp2 = 0;
	    int pointsOp1 = 0;
	    int pointsOp2 = 0;
	    
	    while (!isSetWon(gamesOp1, gamesOp2)) {
	        pointsOp1 = 0;
	        pointsOp2 = 0;
	        
	        while (!isGameWon(pointsOp1, pointsOp2)) {
	            boolean pointForOp1 = Math.random() < 0.5;
	            if (pointForOp1) {
	                pointsOp1++;
	            } else {
	                pointsOp2++;
	            }
	        }
	        
	        if (pointsOp1 > pointsOp2) {
	            gamesOp1++;
	        } else {
	            gamesOp2++;
	        }
	        
	        // Vérifier si un tie-break est nécessaire
	        if (gamesOp1 == 6 && gamesOp2 == 6) {
	            PlayTieBreak();
	            if(getOpponentWinner() == getMatch().getOpponents().get(0)) {
	            	gamesOp1++;
	            }else {
	            	gamesOp2++;
	            }
	        }else {
	        	if (gamesOp1 > gamesOp2) {
			        setOpponentWinner(getMatch().getOpponents().get(0));
			    } else {
			        setOpponentWinner(getMatch().getOpponents().get(1));
			    }
	        }
	    }
	}
	
	public void PlayTieBreak() {
		int pointsOp1 = 0;
	    int pointsOp2 = 0;

	    while (Math.abs(pointsOp1 - pointsOp2) < 2 || (pointsOp1 < 7 && pointsOp2 < 7)) {
	        boolean pointForOp1 = Math.random() < 0.5; // Simule le gain d'un point

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
	
	public boolean isSetWon(int gamesOp1, int gamesOp2) {
	    return (gamesOp1 >= 6 || gamesOp2 >= 6) && Math.abs(gamesOp1 - gamesOp2) >= 2;
	}

	public boolean isGameWon(int pointsOp1, int pointsOp2) {
	    return (pointsOp1 >= 4 || pointsOp2 >= 4) && Math.abs(pointsOp1 - pointsOp2) >= 2;
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
