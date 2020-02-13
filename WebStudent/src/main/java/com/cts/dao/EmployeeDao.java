package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cts.model.Employee;

@Component
public class EmployeeDao {
	static List<Employee> list=null;
	static {		
		list = new ArrayList<Employee>(); 
		list.add(new Employee(1, "Anil", 22));
		list.add(new Employee(2, "Aji", 22));
		list.add(new Employee(3, "Sanal", 23));
		list.add(new Employee(4, "Nibin", 25));
	}
public List<Employee> getUsers(){		
		
		return EmployeeDao.list;
	}	
	public ResponseEntity<?> insertUser(Employee user){
		list.add(user);		
		return new ResponseEntity<Employee>(user, HttpStatus.OK);
	}
	public ResponseEntity<?> getUser(int id){
		for (Employee user : list) {
			if(user.getId() == id) {
				return new ResponseEntity<Employee>(user, HttpStatus.OK);
			}
		}
		return null;
	}
	public int deleteUser(int id){
		for (Employee user : list) {
			if(user.getId() == id) {
				list.remove(user);
				return id;
			}
		}
		return 0;
	}
	public Employee putUser(Employee user){
		for (Employee user2 : list) {
			if(user2.getId() ==user.getId() ) {
				list.remove(user2);
				list.add(user);
				return user;
			}
		}
		return null;
	}
	

}
