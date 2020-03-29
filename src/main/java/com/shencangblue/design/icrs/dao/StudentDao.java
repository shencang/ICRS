package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student,Long> {

    Student findByStudentIdName(String studentIdName);

    Student getByStudentIdNameAndPassword(String studentIdName ,String password);

    List<Student> findByDepartmentId(long departmentId);

    List<Student> getByDepartmentId(long departmentId);

    List<Student> getByStatusAndRole(int state,int role);

    List<Student> getAllByDepartmentIdAndStatus(int state,int depId);

}
