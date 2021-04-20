package ola.com.booking.service;

import java.sql.SQLException;

import ola.com.booking.model.User;

public interface UserService {

	public void saveUser(User user);
	public boolean validateUser(String username, String password);
	public int getUserId(String username, String password) throws SQLException;
}
