package com.shakthi.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakthi.entity.Employee;
import com.shakthi.repo.EmployeeRepository;
import com.shakthi.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	@Override
	public Integer saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp).getEmpId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);

	}

}
