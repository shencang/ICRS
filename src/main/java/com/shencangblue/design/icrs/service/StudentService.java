package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.StudentDao;
import com.shencangblue.design.icrs.model.Department;
import com.shencangblue.design.icrs.model.Student;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentService {
    @Resource
    private StudentDao studentDao;

    @Transactional
    public void add(Student student){
        studentDao.save(student);
    }
    @Transactional
    public Student getById(Long id){
        return studentDao.findById(id).orElse(null);
    }
    @Transactional
    public boolean isExist(String studentIdName){
        return null!= studentDao.findByStudentIdName(studentIdName);

    }
    @Transactional
    public Student getByStudentIdName(String studentIdName){
        return studentDao.findByStudentIdName(studentIdName);
    }
    @Transactional
    public Student studentIdAndPwd(String studentIdName,String password){
        return studentDao.getByStudentIdNameAndPassword(studentIdName,password);
    }



}
