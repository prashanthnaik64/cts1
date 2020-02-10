package com.cts.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.model.User;

@Controller
public class HomeController {
	@RequestMapping("/welcome")
	
	 public String getData() {
		return "home";
	}
	
	
	@RequestMapping("/first")
	public String regUserForm(Model model) {
		model.addAttribute("user", new User());
    	
		return "form";
	}
    
    @RequestMapping("/registerNewUser")
	public String registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult result) {		
		if (result.hasErrors()) {
            return "form";
        }
		
		//userService.addUser(user);
		return "success";
	}
}
