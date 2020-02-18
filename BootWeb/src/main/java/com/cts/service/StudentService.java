package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.StudentDao;
import com.cts.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentDao studentdao;
	public List<Student> getAllUsers(){
		return studentdao.getAllStudents();
	}

}
