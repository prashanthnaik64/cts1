package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cts.model.Student;
import com.cts.service.StudentService;

@RestController
public class HomeController {
	@Autowired
	StudentService studentser;
	@GetMapping("/welcome")
	public String home() {
		return "Prashanth cts";
	}
	@GetMapping("/getAllstudents")
	public List<Student> getUsers(){
				
		return studentser.getAllUsers();
	}

}
