package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	
	EmployeeRepository employeeRepository;
	
	@Transactional
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeRepository.findAll();
	}
	@Transactional
	public Optional<Employee> getEmployeebyId(Long id){
		return employeeRepository.findById( id);
	}
	@Transactional
	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	@Transactional
	public boolean addStudent(Employee employee) {
		return employeeRepository.save(employee) != null;
	}
	@Transactional
	public void deleteStudent(Long personId) {
		employeeRepository.deleteById(personId);
	}
	
	@Transactional
	public boolean updateStudent(Employee person) {
		return employeeRepository.save(person) != null;
	}

}
