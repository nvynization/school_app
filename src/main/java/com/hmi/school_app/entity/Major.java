package com.hmi.school_app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Major {//entity is bean in java and table in database

	@Id //id is in database
	@GeneratedValue(strategy = GenerationType.AUTO)//Generated value is equal to ai in database 
	private Long id;	
	private String name;
	private String description;
	
	@OneToMany //student to major
	private List<Student> Students = new ArrayList<>();
	
	
	public Major() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Student> getStudents() {
		return Students;
	}

	public void setStudents(List<Student> students) {
		Students = students;
	}		
}
