package com.shencangblue.design.icrs.dao.adminDao;

import com.shencangblue.design.icrs.model.admin.AdminMenu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminMenuDao extends CrudRepository<AdminMenu, Integer> {
    List<AdminMenu> findAllByParentId(int ParentId);
}
