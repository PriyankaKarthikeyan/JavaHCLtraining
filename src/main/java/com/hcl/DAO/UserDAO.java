package com.hcl.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	int validate(String username, String password) throws SQLException;

	List<Integer> getUserAccountdetails(int userid);
	

}
