package com.shencangblue.design.icrs.dao.adminDao;

import com.shencangblue.design.icrs.model.admin.AdminRolePermission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRolePermissionDao extends CrudRepository<AdminRolePermission,Integer> {
    List<AdminRolePermission> findAllByRid(int rid);
    void  deleteAllByRid(int rid);

}
