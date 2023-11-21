package be.jossart.dao;

import java.sql.Connection;
import java.util.ArrayList;

import be.jossart.pojo.Match;

public class MatchDAO extends DAO<Match>{

	public MatchDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Match obj) {
		// TODO Auto-generated method stub
		return false;
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
