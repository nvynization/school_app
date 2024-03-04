package com.hmi.school_app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.hmi.school_app.DAO.StudentDAO;
import com.hmi.school_app.entity.Student;

@Service
public class StudentService {
	private final StudentDAO studentDAO;

	public StudentService(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}
	
	public List<Student> getAllStudents(){
		return (List<Student>) studentDAO.findAll();
		
	}
	
	public Student getStudentById(Long studentId) {
		Optional<Student> studentOptional = studentDAO.findById(studentId);
		if(studentOptional.isEmpty()) {
			throw new RuntimeException("student with id="+studentId+"is not found"); 
		}
		return studentOptional.get();
	}
	
	public Student saveStudent(Student student) {
		return studentDAO.save(student);
	}
	
}
