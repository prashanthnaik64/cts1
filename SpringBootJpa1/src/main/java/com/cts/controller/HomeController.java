package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
public class HomeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return (List<Employee>) employeeService.getAllEmployees();
	}
	@RequestMapping(value = "/EmployeebyId/{id}", method = RequestMethod.GET)
	public Optional<Employee> EmployeebyId(@PathVariable long id){
		return employeeService.getEmployeebyId(id);	
	}
	@RequestMapping(value = "/employeeByName/{name}", method = RequestMethod.GET)
	public List<Employee> getStudentByFirstname(@PathVariable String name) {
		return employeeService.findByName(name);
	
	}
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public HttpStatus insertPerson(@RequestBody Employee student) {
		return employeeService.addStudent(student) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteStudent(@PathVariable Long id) {
		employeeService.deleteStudent(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public HttpStatus updateStudent(@RequestBody Employee student) {
		return employeeService.updateStudent(student)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

}
