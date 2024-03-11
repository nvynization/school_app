package com.hmi.school_app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmi.school_app.entity.Student;
import com.hmi.school_app.entity.Teacher;
import com.hmi.school_app.service.StudentService;
import com.hmi.school_app.service.TeacherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

	private final TeacherService teacherService;
	private final StudentService studentService;

	public TeacherController(TeacherService teacherService,StudentService studentService) {
		super();
		this.teacherService = teacherService;
		this.studentService = studentService;
	}
	
	//teacher bat assign link htae lite ml ae d mhar form student form pya ml
	@GetMapping("/all")
	public String all(Model model) {
		List<Teacher> teachers = teacherService.getAllTeachers();
		model.addAttribute("teachers",teachers);		
		return "teacher-list";
	}
	
	@GetMapping("/create")
	public String form(Model model) {
		model.addAttribute("teacher",new Teacher());
		return "add-teacher";
	}
	
	
	/*
	 * public String postMethodName(@RequestBody String entity) { //TODO: process
	 * POST request
	 * 
	 * teacherService.saveteacher(teacher);
	 * 
	 * return "redirect:/teacher/all"; }
	 */
	
	@PostMapping("/create")
	public String postNew(@ModelAttribute Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teacher/all";
	}
	
	@GetMapping("/{teacherId}/assign")
	public String assignForm(@PathVariable Long teacherId,Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students",students);
		Teacher teacher = teacherService.getTeacherById(teacherId);
		model.addAttribute("teacher",teacher);
		return "assign-form";
	}
}
