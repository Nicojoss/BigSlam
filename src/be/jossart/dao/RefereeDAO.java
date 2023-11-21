package be.jossart.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

}
