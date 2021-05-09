package com.elhportal.portal.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.elhportal.portal.dao.EmployeeDao;
import com.elhportal.portal.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	List<Employee> employeeList=new ArrayList<Employee>();

	@Override
	public void saveEmployee(Employee employee) {
		employeeList.add(employee);

	}

	@Override
	public List<Employee> getEmployeeDetails() {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeDetailsByid(int eid) {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public List<Employee> getupdatedEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
			//Employee name=employee.getName();
			employeeList.set(0, employee);
			for(int i=0;i<employeeList.size();i++){
				System.out.println("list details-"+employeeList.get(i));
			}
			return employeeList;
		
	}

	@Override
	public List<Employee> getupdatedEmployeeDetails(String name, String projectDetails, String email, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Employee> getupdatedEmployeeDetails(String name, String projectDetails, String email, String phone) {
//		// TODO Auto-generated method stub
//		List<Employee> employeeListver2=new ArrayList<Employee>();
//			employeeList.get(0);
//		employeeListver2.add(hh);
//		employeeListver2.add(name);
//
//		
//		return employeeList;
//
//	}

}
