package be.jossart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.jossart.pojo.Referee;

public class RefereeDAO extends DAO<Referee>{

	public RefereeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Referee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Referee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Referee obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Referee find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Referee> findAll() {
		ArrayList<Referee> referees = new ArrayList<>();
		
		String query = "SELECT * FROM Referee";
	    
	    try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {

	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	            while (resultSet.next()) {
	                
	            	int id = resultSet.getInt("IdReferee");
	                String firstname = resultSet.getString("Firstname");
	                String lastname = resultSet.getString("Lastname");
	                String nationality = resultSet.getString("Nationality");
	                
	                Referee referee = new Referee(id, firstname, lastname, nationality);
	                referees.add(referee);
	            }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return referees;
	}

}
