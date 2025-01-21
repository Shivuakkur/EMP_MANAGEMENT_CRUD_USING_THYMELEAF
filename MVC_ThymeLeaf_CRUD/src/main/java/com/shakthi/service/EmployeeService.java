package com.shakthi.service;

import java.util.List;

import com.shakthi.entity.Employee;

public interface EmployeeService {

	Integer saveEmployee(Employee emp);
	
	List<Employee> getAllEmployees();
	
	Employee getOneEmployee(Integer id);
	
	void deleteEmployee(Integer id);
	
	void updateEmployee(Employee emp);
}