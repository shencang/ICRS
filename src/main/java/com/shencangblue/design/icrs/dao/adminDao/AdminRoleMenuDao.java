package com.shencangblue.design.icrs.dao.adminDao;

import com.shencangblue.design.icrs.model.admin.AdminRoleMenu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRoleMenuDao extends CrudRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    void deleteAllByRid(int rid);
}
