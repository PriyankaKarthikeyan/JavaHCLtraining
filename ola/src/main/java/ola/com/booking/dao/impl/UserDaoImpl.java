package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn= ConectionManager.getConnection();
	
	@Override
	public void saveUser(User user) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into User (userId, email, name, password, phoneNo) values (?,?,?,?,?)");
			stmt.setInt(1, user.getuserId());
			stmt.setString(2, user.getEmail());
			stmt.setString(3,user.getName());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getPhoneNo());		
			stmt.execute();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean validateUser(String username, String password) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT EXISTS(SELECT * FROM user WHERE name=? and password=?)");
		    stmt.setString(1, username);
		    stmt.setString(2, password);
			//PreparedStatement getUseridstmt = conn.prepareStatement("SELECT userId FROM user WHERE name=? and password=?");
			//getUseridstmt.execute();

			System.out.println("before making true boolean value");

		    //return stmt.execute();
			return stmt.execute();
		   
		} catch (SQLException e) {
			System.out.println("making exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("making false boolean value");
		return false;
	}

	@Override
	public int getUserId(String username, String password) {
		// TODO Auto-generated method stub
		int userId=0;

		try {

		PreparedStatement st=conn.prepareStatement("SELECT userId FROM user WHERE name=? and password=?");
	    st.setString(1, username);
	    st.setString(2, password);
		System.out.println("Before execute ");

		ResultSet rs=st.executeQuery();
		System.out.println("After execute ");
		while(rs.next()) {
		userId=rs.getInt("userId");}
		System.out.println("value of userid inside method="+userId);
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

}
