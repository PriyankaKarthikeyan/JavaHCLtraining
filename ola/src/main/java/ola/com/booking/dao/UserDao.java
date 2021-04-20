package ola.com.booking.dao;

import java.sql.SQLException;

import ola.com.booking.model.User;

public interface UserDao {

	void saveUser(User user);
    boolean validateUser(String username, String password);
	int getUserId(String username, String password) throws SQLException;
}
