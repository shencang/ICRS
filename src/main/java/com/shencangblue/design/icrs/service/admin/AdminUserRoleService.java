package com.shencangblue.design.icrs.service.admin;


import com.shencangblue.design.icrs.dao.adminDao.AdminUserRoleDao;
import com.shencangblue.design.icrs.model.admin.AdminRole;
import com.shencangblue.design.icrs.model.admin.AdminUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserRoleService {
    @Resource
    AdminUserRoleDao adminUserRoleDao;

    public List<AdminUserRole> listAllByUid(int uid) {
        return adminUserRoleDao.findAllByUid(uid);
    }

//    @Modifying
    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles) {
        adminUserRoleDao.deleteAllByUid(uid);
        for (AdminRole role : roles) {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(role.getId());
            adminUserRoleDao.save(ur);
        }
    }
}
