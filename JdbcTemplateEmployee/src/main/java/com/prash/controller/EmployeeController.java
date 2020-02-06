package com.prash.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prash.model.EmployeeModel;
import com.prash.service.EmployeeService;

@Controller
public class EmployeeController {
	@RequestMapping("/welcome")
	   String home() {
		   return "welcome";
	   }
	
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/listEmployees")
	   String getStudents(Model model) {
		   List<EmployeeModel> list = employeeService.getAllEmployees();
		   System.out.println(list);
		   model.addAttribute("listemp", list);
		   return "listemployees";
	   }

}
