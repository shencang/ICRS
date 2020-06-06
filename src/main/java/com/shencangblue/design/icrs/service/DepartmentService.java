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

    /**
     * 获取所有组织
     * @return 所有组织
     */
    @Transactional
    public Iterable<Department> getAll() {
        return departmentDao.findAll();
    }

    /**
     * 删除某个组织
     * @param id 要删除组织的iD
     */
    @Transactional
    public void delete(long id) {
        departmentDao.deleteById(id);
    }

    /**
     * 新建或者保存指定的组织
     * @param department 要保存或者修改的的组织
     */
    @Transactional
    public void save(Department department) {
        departmentDao.save(department);
    }

    /**
     * 修改指定组织
     * @param department 要修改的组织
     */
    @Transactional
    public void update(Department department) {
        departmentDao.save(department);
    }

    /**
     * 以ID获取指定的组织
     * @param id 要获取的ID
     * @return 要查找的组织
     */
    @Transactional
    public Department getById(Long id) {
        return departmentDao.findById(id).orElse(null);
    }

}