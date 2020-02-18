package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cts.model.Student;

@Repository
public class StudentDao {
	public List<Student>  getAllStudents() { 
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "Anil", 22));
		list.add(new Student(2, "arun", 25));
		list.add(new Student(3, "Amar", 23));
		return list;
	}

}
	
