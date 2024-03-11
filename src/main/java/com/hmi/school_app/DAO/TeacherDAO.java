package com.hmi.school_app.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hmi.school_app.entity.Teacher;

public interface TeacherDAO extends CrudRepository<Teacher, Long>{

}
