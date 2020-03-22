package com.shencangblue.design.icrs.service.admin;

import com.shencangblue.design.icrs.dao.adminDao.AdminRolePermissionDao;
import com.shencangblue.design.icrs.model.admin.AdminPermission;
import com.shencangblue.design.icrs.model.admin.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminRolePermissionService {
    @Resource
    AdminRolePermissionDao adminRolePermissionDao;

    List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDao.findAllByRid(rid);
    }

//    @Modifying
    @Transactional
    public void savePermChanges(int rid, List<AdminPermission> perms) {
        adminRolePermissionDao.deleteAllByRid(rid);
        for (AdminPermission perm : perms) {
            AdminRolePermission rp = new AdminRolePermission();
            rp.setRid(rid);
            rp.setPid(perm.getId());
            adminRolePermissionDao.save(rp);
        }
    }
}
