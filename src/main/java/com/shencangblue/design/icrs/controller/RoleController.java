package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.admin.AdminPermission;
import com.shencangblue.design.icrs.model.admin.AdminRole;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.admin.AdminPermissionService;
import com.shencangblue.design.icrs.service.admin.AdminRoleMenuService;
import com.shencangblue.design.icrs.service.admin.AdminRolePermissionService;
import com.shencangblue.design.icrs.service.admin.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class RoleController {
    @Resource
    AdminRoleService adminRoleService;
    @Resource
    AdminPermissionService adminPermissionService;
    @Resource
    AdminRolePermissionService adminRolePermissionService;
    @Resource
    AdminRoleMenuService adminRoleMenuService;

    @GetMapping("/api/admin/role")
    public Iterable<AdminRole> listRoles(){
        return adminRoleService.list();
    }

    @PutMapping("/api/admin/role/status")
    public Result updateRoleStatus(@RequestBody AdminRole requestRole) {
        AdminRole adminRole = adminRoleService.updateRoleStatus(requestRole);
        String message = "用户" + adminRole.getNameZh() + "状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @PutMapping("/api/admin/role")
    public Result editRole(@RequestBody AdminRole requestRole) {
        adminRoleService.addOrUpdate(requestRole);
        adminRolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        String message = "修改角色信息成功";
        return ResultFactory.buildSuccessResult(message);
    }


    @PostMapping("/api/admin/role")
    public Result addRole(@RequestBody AdminRole requestRole) {
        if (adminRoleService.editRole(requestRole)) {
            return ResultFactory.buildSuccessResult("修改用户成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，修改失败");
        }
    }

    @GetMapping("/api/admin/role/perm")
    public Iterable<AdminPermission> listPerms() {
        return adminPermissionService.list();
    }

    @PutMapping("/api/admin/role/menu")
    public Result updateRoleMenu(@RequestParam int rid, @RequestBody LinkedHashMap menusIds) {
        if(adminRoleMenuService.updateRoleMenu(rid, menusIds)) {
            return ResultFactory.buildSuccessResult("更新成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，更新失败");
        }
    }
}
