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
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    /**
     * h获取角色列表
     * @return 返回角色列表
     */
    @GetMapping("/api/admin/role")
    public Result listRoles() {
        return ResultFactory.buildSuccessResult(adminRoleService.listWithPermsAndMenus());
    }

    /**
     * 获取角色状态
     * @param requestRole 要查询的角色
     * @return 封装好的消息
     */
    @PutMapping("/api/admin/role/status")
    public Result updateRoleStatus(@RequestBody AdminRole requestRole) {
        AdminRole adminRole = adminRoleService.updateRoleStatus(requestRole);
        String message = "用户" + adminRole.getNameZh() + "状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }

    /**
     * 修改角色信息
     * @param requestRole 要修改的角色信息
     * @return 封装好的消息
     */
    @PutMapping("/api/admin/role")
    public Result editRole(@RequestBody AdminRole requestRole) {
        adminRoleService.addOrUpdate(requestRole);
        adminRolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        String message = "修改角色信息成功";
        return ResultFactory.buildSuccessResult(message);
    }


    /**
     * 修改用户用户角色
     * @param requestRole 要修改的角色
     * @return 封装好的修改成功消息
     */
    @PostMapping("/api/admin/role")
    public Result addRole(@RequestBody AdminRole requestRole) {
        adminRoleService.editRole(requestRole);
        return ResultFactory.buildSuccessResult("修改用户成功");
    }

    /**
     * 查询用户权限
     * @return 用户所有权限
     */
    @GetMapping("/api/admin/role/perm")
    public Result listPerms() {
        return ResultFactory.buildSuccessResult(adminPermissionService.list());
    }

    /**
     * 更新角色菜单
     * @param rid 角色ID
     * @param menusIds 菜单ID
     * @return 封装好的成功消息
     */
    @PutMapping("/api/admin/role/menu")
    public Result updateRoleMenu(@RequestParam int rid, @RequestBody Map<String, List<Integer>> menusIds) {
        adminRoleMenuService.updateRoleMenu(rid, menusIds);
        return ResultFactory.buildSuccessResult("更新成功");
    }
}
