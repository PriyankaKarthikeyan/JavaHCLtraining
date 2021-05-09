package com.elhportal.portal.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.elhportal.portal.entity.Employee;

@Repository
public interface EmployeeDao {

	void saveEmployee(Employee employee);

	List<Employee> getEmployeeDetails();

	List<Employee> getEmployeeDetailsByid(int eid);

	List<Employee> getupdatedEmployeeDetails(Employee employee);


	List<Employee> getupdatedEmployeeDetails(String name, String projectDetails, String email, String phone);
	
	

}
