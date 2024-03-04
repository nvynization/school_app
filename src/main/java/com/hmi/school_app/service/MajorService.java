package com.hmi.school_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hmi.school_app.DAO.MajorDAO;
import com.hmi.school_app.entity.Major;

@Service
public class MajorService {
	
	private final MajorDAO majorDAO;

	public MajorService(MajorDAO majorDAO) {
		super();
		this.majorDAO = majorDAO;
	}
	
	public List<Major> getAllMajors(){		
		return (List<Major>) majorDAO.findAll();//iterable ko list cast lote		
	}
	
	public Major getMajorById(Long majorId) {
		Optional<Major> majorOptional = majorDAO.findById(majorId);
		if(majorOptional.isEmpty()) {
			System.out.println("major with id ="+majorId+"is not found");
			throw new RuntimeException();
		}
		return majorOptional.get();		
	}
	
	public Major saveMajor(Major major) {
		return majorDAO.save(major);
	}
	
	public void deleteMajorById(Long majorId) {
		majorDAO.deleteById(majorId);
	}	
}
