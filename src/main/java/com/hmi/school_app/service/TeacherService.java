package com.hmi.school_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hmi.school_app.DAO.TeacherDAO;
import com.hmi.school_app.entity.Teacher;

@Service //why service notation set is 
public class TeacherService {

	private final TeacherDAO teacherDAO;

	public TeacherService(TeacherDAO teacherDAO) {
		super();
		this.teacherDAO = teacherDAO;
	}
	
	public List<Teacher> getAllTeachers(){
		return (List<Teacher>)teacherDAO.findAll();
	}
	
	public Teacher saveTeacher(Teacher teacher) {
		
		return teacherDAO.save(teacher);
	}
	
	public Teacher getTeacherById(Long teacherId) {
		Optional<Teacher> teacherOptional = teacherDAO.findById(teacherId);
		
		if(teacherOptional.isEmpty()) {
			throw new RuntimeException("teacher with id = "+teacherId+"is occured error.");
		}
		return teacherOptional.get();
	}
}
