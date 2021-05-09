package com.elhportal.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhportal.portal.dao.EmployeeDao;
import com.elhportal.portal.entity.Employee;
import com.elhportal.portal.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	int count=1;

	@Override
	public void saveEmployee(Employee employee) {
	employee.setEid(++count);
	employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeDetails() {
		// TODO Auto-generated method stub
		List<Employee> empDetails=employeeDao.getEmployeeDetails();
		return empDetails;
	}

	@Override
	public List<Employee> getEmployeeByid(int eid) {
		List<Employee> empDetailsbyId=employeeDao.getEmployeeDetailsByid(eid);
		return empDetailsbyId;
	}

	@Override
	public List<Employee> saveUpdatedEmployee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> empDetailsupdated=employeeDao.getupdatedEmployeeDetails(employee);
		return empDetailsupdated;

	}

	@Override
	public List<Employee> saveUpdatedEmployee(String name, String projectDetails, String email, String phone) {
		// TODO Auto-generated method stub
		List<Employee> empDetailsupdatedbystring=employeeDao.getupdatedEmployeeDetails(name,projectDetails,email,phone);

		return empDetailsupdatedbystring;
	}



}
