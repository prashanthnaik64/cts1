package com.cts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	List<Employee> findByName(String name);

}
