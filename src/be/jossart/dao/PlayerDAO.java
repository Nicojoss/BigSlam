package be.jossart.dao;

import java.sql.Connection;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return null;
	}
}
