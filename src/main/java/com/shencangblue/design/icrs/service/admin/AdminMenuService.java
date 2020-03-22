package com.shencangblue.design.icrs.service.admin;


import com.shencangblue.design.icrs.dao.adminDao.AdminMenuDao;
import com.shencangblue.design.icrs.model.Student;
import com.shencangblue.design.icrs.model.admin.AdminMenu;
import com.shencangblue.design.icrs.model.admin.AdminRoleMenu;
import com.shencangblue.design.icrs.model.admin.AdminUserRole;
import com.shencangblue.design.icrs.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminMenuService {
    @Resource
    AdminMenuDao adminMenuDao;
    @Resource
    StudentService studentService;
    @Resource
    AdminUserRoleService adminUserRoleService;
    @Resource
    AdminRoleMenuService adminRoleMenuService;

    public List<AdminMenu> getAllByParentId(int parentId) {return adminMenuDao.findAllByParentId(parentId);}

    public List<AdminMenu> getMenusByCurrentUser() {
        String studentIdName = SecurityUtils.getSubject().getPrincipal().toString();
        Student student = studentService.getByStudentIdName(studentIdName);
       //这里使用了强转 -jin hao
        List<AdminUserRole> userRoleList = adminUserRoleService.listAllByUid((int)student.getStudentId());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole userRole : userRoleList) {
            List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(userRole.getRid());
            for (AdminRoleMenu rm : rms) {
                // 增加防止多角色状态下菜单重复的逻辑
                AdminMenu menu = adminMenuDao.findById(rm.getMid()).orElse(null);
                boolean isExist = false;
                for (AdminMenu m : menus) {
                    if (m.getId() == menu.getId()) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    menus.add(menu);
                }
            }
        }
        handleMenus(menus);
        return menus;
    }

    public List<AdminMenu> getMenusByRoleId(int rid) {
        List<AdminMenu> menus = new ArrayList<>();
        List<AdminRoleMenu> rms = adminRoleMenuService.findAllByRid(rid);
        for (AdminRoleMenu rm : rms) {
            menus.add(adminMenuDao.findById(rm.getMid()).orElse(null));
        }
        handleMenus(menus);
        return menus;
    }

    public void handleMenus(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            List<AdminMenu> children = getAllByParentId(menu.getId());
            menu.setChildren(children);
        }

        menus.removeIf(menu -> menu.getParentId() != 0);
    }
}
