package com.Student.API.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.API.Student.model.Student;
import com.Student.API.Student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepo;

	public List<Student> getAllDetails() {
		List<Student> stu = studentrepo.findAll();
		return stu;
	}
	
	public void setStudent(Student  student) {
		studentrepo.save(student);	
	}

	public Student findById(Integer id) {
		Student sudo = studentrepo.findById(id).get();
		return sudo;		
	}

	public Student findByStudentId(Integer employeeId, Student student) {
		Student sudo = studentrepo.findById(employeeId).get();
		sudo.setAge(student.getAge());
		sudo.setDob(student.getDob());
		sudo.setEmail(student.getEmail());
		sudo.setName(student.getName());
		final Student updateStudent = studentrepo.save(sudo);
		return updateStudent;
	}

	public Student findByIdToDelete(Integer employeeId) {
		Student studs = studentrepo.findById(employeeId).get();
		studentrepo.delete(studs);
		return studs;
	}
}
