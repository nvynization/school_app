package com.hmi.school_app.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hmi.school_app.entity.Major;
import com.hmi.school_app.service.MajorService;

@Controller
public class MajorController {
	
	private final MajorService majorService;
	
	public MajorController(MajorService majorService) {
		super();
		this.majorService = majorService;
	}

	@GetMapping("/all")//dopost doget methods
	public String all(Model model) {// model is supported by spring mvc framework
		
		List<Major> majorList = majorService.getAllMajors();				
		model.addAttribute("majorList",majorList);
		return "major-list";
	}
	
	//post is data create in server
	/*@PostMapping("/create")
	public String create() {		
		return "add-major.html";
	}*/
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("major",new Major());
		return "add-major";
	}
	
	//post is data create in server
	@PostMapping("/create")
	public String postMajor(@ModelAttribute/*(name ="name") can be specify*/ Major major) {
		Major createdMajor = majorService.saveMajor(major);
		System.out.println("created major id = "+createdMajor.getId());
		
		return "redirect:/all";		
	}
}
