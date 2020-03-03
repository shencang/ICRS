package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.MeetingRoom;
import com.shencangblue.design.icrs.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student,Long> {

    Student findByStudentIdName(String studentIdName);

    Student getByStudentIdNameAndPassword(String studentIdName ,String password);
}
