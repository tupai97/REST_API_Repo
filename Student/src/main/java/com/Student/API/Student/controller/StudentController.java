package com.Student.API.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.API.Student.model.Student;
import com.Student.API.Student.service.StudentService;

@RestController
@RequestMapping("/api/auth")
public class StudentController {
	
	
			
			@Autowired
			private StudentService studentservice;
				
			//@CrossOrigin used when you want to use cross-origin resource sharing only for this specific method
			@PostMapping("/student")
			public void createStudent(@RequestBody Student student) {
				if(student.getAge()<28) {
					studentservice.setStudent(student);
				}
				else {
					System.out.println("bad request");
				}			
			}
			
			
			@GetMapping("/students")
			public List<Student> ListStudent(){
				List<Student> sudo = studentservice.getAllDetails();
				return sudo;
			}
			
			/* getOne(id) s a lazy load operation. Thus you get only a reference (a proxy) to the entity.
			That means no DB access is actually made. Only when you call it's properties then 
			it will query the DB . findByID does the call 'eagerly'/immediately when you call it,
			 thus you have the actual entity fully populated.*/
			
			@GetMapping("/student/{id}")							
			public Student getById(@PathVariable Integer id) {
				Student stu = studentservice.findById(id);
				return stu;
			}
		
			@PutMapping("/update-student/{id}")
		    public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") Integer employeeId,
		          @RequestBody Student student) {
				Student stu = studentservice.findByStudentId(employeeId , student); 	
		        return ResponseEntity.ok(stu);
		    }
		
			@DeleteMapping("/student/{id}")	
			 public ResponseEntity<Student> deletestudent(@PathVariable(value = "id") Integer employeeId)
		    {
				Student stud = studentservice.findByIdToDelete(employeeId);
		        return ResponseEntity.ok(stud);
		    }
}

