package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.DepartmentDao;
import com.shencangblue.design.icrs.model.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class DepartmentService {

    @Resource
    DepartmentDao departmentDao;

    @Transactional
    public Iterable<Department> getAll() {
        return departmentDao.findAll();
    }

    @Transactional
    public void delete(long id) {
        departmentDao.deleteById(id);
    }

    @Transactional
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Transactional
    public void update(Department department) {
        departmentDao.save(department);
    }

    @Transactional
    public Department getById(Long id) {
        return departmentDao.findById(id).orElse(null);
    }

}