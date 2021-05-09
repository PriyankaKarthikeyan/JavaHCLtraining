package com.hcl.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.ConnectionManager;
import com.hcl.DAO.UserDAO;
import com.hcl.model.User;

/**
 * @author yash.ghawghawe
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	Session session = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().openSession();

	public int validate(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("validate method");
		Transaction t = session.beginTransaction();

		List<Integer> userid;
		String query="select userid from User where username=:username and password=:password";
		Query hquery = session.createQuery(query);
		hquery.setString("username", username);
		hquery.setString("password", password);
		hquery.executeUpdate();
		userid=hquery.list();
		t.commit();
		return userid.get(0);
	}

	public List<Integer> getUserAccountdetails(int userid) {
		// TODO Auto-generated method stub
		List<Integer> userdetails=new ArrayList<Integer>();
		int accountno = 0;
		int balance=0;
		try{
		Transaction t = session.beginTransaction();
		String query = "select accountno, balance from Account where userid =:userid";
		Query hquery = session.createQuery(query);
		hquery.setInteger("userid", userid);
		hquery.executeUpdate();
		userdetails=hquery.list();
		t.commit();
		return userdetails;
	}

}
