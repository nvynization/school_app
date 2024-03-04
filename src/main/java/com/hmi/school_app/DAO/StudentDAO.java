package com.hmi.school_app.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hmi.school_app.entity.Student;

public interface StudentDAO extends CrudRepository<Student, Long>{

}
