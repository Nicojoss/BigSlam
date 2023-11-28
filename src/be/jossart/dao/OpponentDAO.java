package be.jossart.dao;

import java.sql.Connection;
import java.util.ArrayList;

import be.jossart.pojo.Opponent;

public class OpponentDAO extends DAO<Opponent> {

	public OpponentDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Opponent obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Opponent obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Opponent obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Opponent find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Opponent> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
