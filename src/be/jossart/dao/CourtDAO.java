package be.jossart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.jossart.pojo.Court;

public class CourtDAO extends DAO<Court>{

	public CourtDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Court find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Court> findAll() {
		ArrayList<Court> courts = new ArrayList<>();
		
		String query = "SELECT * FROM Court";
	    
	    try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {

	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	            while (resultSet.next()) {
	                
	            	int id = resultSet.getInt("IdCourt");
	                String nameCourt = resultSet.getString("NameCourt");
	                int nbSpectators = resultSet.getInt("NbSpectators");
	                boolean covered = resultSet.getBoolean("Covered");
	                
	                Court court = new Court(id, nameCourt, nbSpectators, covered);
	                courts.add(court);
	            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return courts;
	}

}
