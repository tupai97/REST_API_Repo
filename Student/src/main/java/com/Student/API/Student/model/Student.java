package com.Student.API.Student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="studentdetail")
public class Student {
	@Id
	@Column(name="id", nullable = false)
	@SequenceGenerator(name="studentdetail_seq",sequenceName = "studentdetail_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "studentdetail_seq")
	private Integer id;
	private String name;
	private String email;
	private String dob;
	private Integer age;
	
	public void Student() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
