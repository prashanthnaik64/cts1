package com.cts.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.Student;
import com.cts.repository.StudentRepository;

@Service
@Transactional

public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudent(){
		return (List<Student>) studentRepository.findAll();
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

}
