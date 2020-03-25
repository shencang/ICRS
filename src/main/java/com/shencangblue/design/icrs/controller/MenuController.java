package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.admin.AdminMenu;
import com.shencangblue.design.icrs.service.admin.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MenuController {
    @Resource
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }

    @GetMapping("/api/admin/role/menu")
    public List<AdminMenu> listAllMenus() {
        return adminMenuService.getMenusByRoleId(1);
    }

}
