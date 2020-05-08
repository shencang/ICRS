package com.shencangblue.design.icrs.controller;


import com.shencangblue.design.icrs.dto.UserDTO;
import com.shencangblue.design.icrs.model.User;
import com.shencangblue.design.icrs.model.admin.AdminRole;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.UserService;
import com.shencangblue.design.icrs.service.admin.AdminUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    /**
     * 获取用户列表
     * @return 封装好的所有用户
     */
    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    /**
     * 更新用户状态
     * @param requestUser 用户的身份凭据
     * @return 封装好的成功消息
     */
    @PutMapping("/api/admin/user/status")
    public Result updateUserStatus(@RequestBody @Valid User requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("用户状态更新成功");
    }

    /**
     * 重置用户密码
     * @param requestUser 用户的身份凭据
     * @return 封装好的用户重置消息
     */
    @PutMapping("/api/admin/user/password")
    public Result resetPassword(@RequestBody @Valid User requestUser) {
        userService.resetPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

    /**
     * 编辑用户
     * @param requestUser 要保存的用户信息
     * @return 封装好的修改成功的消息
     */
    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改用户信息成功");
    }

    /**
     * 获取在封装的用户消息
     * @param requestUser 用户的身份凭据
     * @return 再封装的用户信息
     */
    @RequestMapping("/api/info/userInfo")
    public Result UserInfo(@RequestBody User requestUser) {
        System.out.println(requestUser.getUsername());
        UserDTO userDTO =  new UserDTO().convertFrom( userService.findByUsername(requestUser.getUsername()));
//        List<UserDTO> userDTOS = users
//                .stream().map(user -> (UserDTO) new UserDTO().convertFrom(user)).collect(Collectors.toList());
        return ResultFactory.buildSuccessResult(userDTO);
    }

}
