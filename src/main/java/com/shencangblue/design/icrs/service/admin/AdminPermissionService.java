package com.shencangblue.design.icrs.service.admin;


import com.shencangblue.design.icrs.dao.adminDao.AdminPermissionDao;
import com.shencangblue.design.icrs.model.Student;
import com.shencangblue.design.icrs.model.admin.AdminPermission;
import com.shencangblue.design.icrs.model.admin.AdminRole;
import com.shencangblue.design.icrs.model.admin.AdminRolePermission;
import com.shencangblue.design.icrs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AdminPermissionService {
    @Resource
    AdminPermissionDao adminPermissionDao;
    @Resource
    AdminUserRoleService adminUserRoleService;
    @Resource
    AdminRoleService adminRoleService;
    @Resource
    AdminRolePermissionService adminRolePermissionService;
    @Resource
    StudentService studentService;

    public AdminPermission findById(int id) {
        return adminPermissionDao.findById(id).orElse(null);
    }

    public Iterable<AdminPermission> list() {return adminPermissionDao.findAll();}

    public boolean needFilter(String requestAPI) {
        Iterable<AdminPermission> ps = adminPermissionDao.findAll();
        for (AdminPermission p: ps) {
            // 这里我们进行前缀匹配，拥有父权限就拥有所有子权限
            if (requestAPI.startsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }

    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<AdminRolePermission> rps = adminRolePermissionService.findAllByRid(rid);
        List<AdminPermission> perms = new ArrayList<>();
        for (AdminRolePermission rp : rps) {
            perms.add(adminPermissionDao.findById(rp.getPid()).orElse(null));
        }
        return perms;
    }

    public Set<String> listPermissionURLsByUser(String username) {
        List<AdminRole> roles = adminRoleService.listRolesByUser(username);
        Set<String> URLs = new HashSet<>();

        for (AdminRole role : roles) {
            List<AdminRolePermission> rps = adminRolePermissionService.findAllByRid(role.getId());
            for (AdminRolePermission rp : rps) {
                URLs.add(adminPermissionDao.findById(rp.getPid()).orElse(null).getUrl());
            }
        }
        return URLs;
    }
}
