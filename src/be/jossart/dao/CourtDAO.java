package be.jossart.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

}
