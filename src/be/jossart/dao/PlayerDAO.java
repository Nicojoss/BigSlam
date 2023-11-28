package be.jossart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.jossart.pojo.Player;

public class PlayerDAO extends DAO<Player>{

	public PlayerDAO(Connection conn) {
		super(conn);
	}
	@Override
	public boolean create(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Player> findAll() {
		List<Player> players = new ArrayList<>();
		
		String query = "SELECT * FROM Player";
		
		try(PreparedStatement preparedStatement = connect.prepareStatement(query)){
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while(resultSet.next()) {
	        	String firstname = resultSet.getString("Firstname");
                String lastname = resultSet.getString("Lastname");
                String genderPlayer = resultSet.getString("Gender");
                int id = resultSet.getInt("IdPlayer");
                String nationality = resultSet.getString("Nationality");
                int rank = resultSet.getInt("PlayerRank");
                
                Player player = new Player(id, firstname, lastname, genderPlayer, nationality, rank);
                players.add(player);
	        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Player>) players;	
	}
	public Player findByGender(String gender) {
		Player player = null;
		
		String query = "SELECT * FROM Player WHERE gender = ? LIMIT 1";
	    
	    try (PreparedStatement preparedStatement = connect.prepareStatement(query)) {

	        preparedStatement.setString(1, gender);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	            if (resultSet.next()) {
	                
	                String firstname = resultSet.getString("Firstname");
	                String lastname = resultSet.getString("Lastname");
	                String genderPlayer = resultSet.getString("Gender");
	                int id = resultSet.getInt("IdPlayer");
	                String nationality = resultSet.getString("Nationality");
	                int rank = resultSet.getInt("PlayerRank");
	                
	                player = new Player(id, firstname, lastname, genderPlayer, nationality, rank);
	            }
	    }catch (SQLException e){
	        e.printStackTrace();
	    }

	    return player;
	}
	public List<Player> findPlayersByGender(String gender) {
		List<Player> players = new ArrayList<>();
		
		String query = "SELECT * FROM Player WHERE gender = ?";
		
		try(PreparedStatement preparedStatement = connect.prepareStatement(query)){
			preparedStatement.setString(1, gender);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while(resultSet.next()) {
	        	String firstname = resultSet.getString("Firstname");
                String lastname = resultSet.getString("Lastname");
                String genderPlayer = resultSet.getString("Gender");
                int id = resultSet.getInt("IdPlayer");
                String nationality = resultSet.getString("Nationality");
                int rank = resultSet.getInt("PlayerRank");
                
                Player player = new Player(id, firstname, lastname, genderPlayer, nationality, rank);
                players.add(player);
	        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return players;
	}
}
