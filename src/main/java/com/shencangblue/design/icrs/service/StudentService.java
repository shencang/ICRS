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
    public void save(Student student){
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

    @Transactional
    public Iterable<Student> getAll(){
        return studentDao.findAll();
    }
    @Transactional
    public void delete(Long id){
        studentDao.deleteById(id);
    }

    @Transactional
    public void updateStatus(Student student){
        studentDao.save(student);
    }

    @Transactional
    public Iterable<Student> getUnApproveAccount(){
        return studentDao.getByStatusAndRole(0,2);
    }

    @Transactional
    public Iterable<Student> getStuByDepId(int depId){
        return studentDao.getAllByDepartmentIdAndStatus(1,depId);
    }

    @Transactional
    public int reg(Student student){
        studentDao.save(student);
        return 0;
        //todo 等待改动
    }


}
