package com.prash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.dao.EmployeeDao;
import com.prash.model.EmployeeModel;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<EmployeeModel> getAllEmployees(){
    	return employeeDao.getAllEmployees();
    }
	
	

}
