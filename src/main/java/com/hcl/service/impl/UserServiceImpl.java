package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.DAO.UserDAO;
import com.hcl.model.User;
import com.hcl.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userdao;
	
	public int validate(String username, String password) {
		int  userid=0;
		userid= userdao.validate(username,password);
		System.out.println("value of userid:"+userid);
		return userid;
	}

	public List<Integer> getUserAccountdetails(int userid) {
		List<Integer> accountdetailsofuser=userdao.getUserAccountdetails(userid);
		return accountdetailsofuser;
	}

}
