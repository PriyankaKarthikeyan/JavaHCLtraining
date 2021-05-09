package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface UserService {

	int validate(String username, String password);

	List<Integer> getUserAccountdetails(int userid);
	
}
