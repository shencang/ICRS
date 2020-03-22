package com.shencangblue.design.icrs.service.admin;


import com.shencangblue.design.icrs.dao.adminDao.AdminRoleDao;
import com.shencangblue.design.icrs.model.Student;
import com.shencangblue.design.icrs.model.admin.AdminMenu;
import com.shencangblue.design.icrs.model.admin.AdminPermission;
import com.shencangblue.design.icrs.model.admin.AdminRole;
import com.shencangblue.design.icrs.model.admin.AdminUserRole;
import com.shencangblue.design.icrs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminRoleService {
    @Resource
    AdminRoleDao adminRoleDao;
    @Resource
    StudentService studentService;
    @Resource
    AdminUserRoleService adminUserRoleService;
    @Resource
    AdminPermissionService adminPermissionService;
    @Resource
    AdminRolePermissionService adminRolePermissionService;
    @Resource
    AdminMenuService adminMenuService;

    public Iterable<AdminRole> list() {
        Iterable<AdminRole> roles = adminRoleDao.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public AdminRole findById(int id) {
        return adminRoleDao.findById(id).orElse(null);
    }

    public void addOrUpdate(AdminRole adminRole) {
        adminRoleDao.save(adminRole);
    }

    public List<AdminRole> listRolesByUser(String studentIdName) {
        //这里使用了强转 -jin hao
        int uid = (int) studentService.getByStudentIdName(studentIdName).getStudentId();
        List<AdminRole> roles = new ArrayList<>();
        List<AdminUserRole> urs = adminUserRoleService.listAllByUid(uid);
        for (AdminUserRole ur: urs) {
            roles.add(adminRoleDao.findById(ur.getRid()).orElse(null));
        }
        return roles;
    }

    public AdminRole updateRoleStatus(AdminRole role) {
        AdminRole roleInDB = adminRoleDao.findById(role.getId()).orElse(null);
        roleInDB.setEnabled(role.isEnabled());
        return adminRoleDao.save(roleInDB);
    }

    public boolean editRole(@RequestBody AdminRole requestRole) {
        try {
            adminRoleDao.save(requestRole);
            adminRolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
