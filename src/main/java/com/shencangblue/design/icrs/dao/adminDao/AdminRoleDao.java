package com.shencangblue.design.icrs.dao.adminDao;

import com.shencangblue.design.icrs.model.admin.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRoleDao extends JpaRepository<AdminRole,Integer> {
    AdminRole findById(int id);

}
