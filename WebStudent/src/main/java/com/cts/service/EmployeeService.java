package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.EmployeeDao;
import com.cts.model.Employee;



@Service
public class EmployeeService {
	@Autowired
	EmployeeDao userDao;
	
	public List<Employee> getAllUsers(){
		return userDao.getUsers();
	}
	
	public int delete(int id){
		return userDao.deleteUser( id);
	}

}
