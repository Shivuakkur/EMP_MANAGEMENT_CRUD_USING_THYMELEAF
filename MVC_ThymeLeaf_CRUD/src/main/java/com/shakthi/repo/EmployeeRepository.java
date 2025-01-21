package com.shakthi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakthi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
