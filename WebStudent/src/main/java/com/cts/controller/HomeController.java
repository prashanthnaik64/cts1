package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dao.EmployeeDao;
import com.cts.model.Employee;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;
import com.cts.service.EmployeeService;

@RestController
public class HomeController {
	@Autowired
	EmployeeDao dao;
   
	@RequestMapping("/homedata")
	public ResponseEntity<?> getHomeData() {
		
		return new ResponseEntity<Employee>(new Employee(11,"Giri", 45), HttpStatus.OK);
			
	}
	
	@GetMapping("/getAllUsers")
	public List<Employee> getUsers(){
				
		return dao.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int id) {
		return dao.getUser(id);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody Employee user) {
		return dao.insertUser(user);
	}
	
	@DeleteMapping("user/{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return dao.deleteUser(id);
	}
	
	@DeleteMapping("delete/{id}")
	public int delete(@PathVariable("id") int id) {
		return dao.deleteUser(id);
	}
	
	@PutMapping("/user")
	public Employee putUser(@RequestBody Employee user) {
		return dao.putUser(user);
	}
	@Autowired
	EmployeeService userService;
	@RequestMapping("/listUsers")
		List<Employee> getUsers(Model model) {
		List<Employee> list = userService.getAllUsers();
		model.addAttribute("list", list);
		
		return list;
	}

}
