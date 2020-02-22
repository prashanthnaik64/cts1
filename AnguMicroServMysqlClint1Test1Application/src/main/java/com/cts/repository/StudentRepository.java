package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
