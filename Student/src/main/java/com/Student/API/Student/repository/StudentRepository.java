package com.Student.API.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.API.Student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
