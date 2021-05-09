package com.elhportal.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.elhportal.portal.entity.Employee;


@Service
public interface EmployeeService {
	

	void saveEmployee(Employee employee);

	List<Employee> getEmployeeDetails();

	List<Employee> getEmployeeByid(int eid);

	List<Employee> saveUpdatedEmployee(Employee employee);

	List<Employee> saveUpdatedEmployee(String name, String projectDetails, String email, String phone);

}
