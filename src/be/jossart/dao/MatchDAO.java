package be.jossart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import be.jossart.pojo.Match;

public class MatchDAO extends DAO<Match>{

	public MatchDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Match obj) {
		String sql = "INSERT INTO MatchTennis (IdCourt, IdPlayerWinner1, IdPlayerWinner2, IdPlayerLoser1, IdPlayerLoser2, IdReferee, ScoreOp1, ScoreOp2) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = connect.prepareStatement(sql)) {
	       statement.setInt(1, obj.getCourt().getId());
	
	       if (obj.isDoublesMatch()) {
	           statement.setInt(2, obj.getWinnerPlayer().get(0).getId());
	           statement.setInt(3, obj.getWinnerPlayer().get(1).getId());
	           statement.setInt(4, obj.getLoserPlayer().get(0).getId());
	           statement.setInt(5, obj.getLoserPlayer().get(1).getId());
	       } else {
	           statement.setInt(2, obj.getWinnerPlayer().get(0).getId());
	           statement.setNull(3, java.sql.Types.INTEGER);
	           statement.setInt(4, obj.getLoserPlayer().get(0).getId());
	           statement.setNull(5, java.sql.Types.INTEGER);
	       }
	
	       statement.setInt(6, obj.getReferee().getId());
	       statement.setInt(7, obj.getSetsWonByPlayer1());
	       statement.setInt(8, obj.getSetsWonByPlayer2());
	
	       int rows = statement.executeUpdate();
	       return rows > 0;
	
	   } catch (SQLException e) {
	       e.printStackTrace();
	       return false;
	   }
	}

	@Override
	public boolean delete(Match obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Match obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Match find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Match> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
