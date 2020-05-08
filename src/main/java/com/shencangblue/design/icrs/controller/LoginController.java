package com.shencangblue.design.icrs.controller;


import com.shencangblue.design.icrs.model.User;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录方法
     * @param requestUser 登录用户凭据
     * @return 封装的是否登录成功
     */
    @PostMapping("/api/login")
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.findByUsername(username);
            if (!user.isEnabled()) {
                return ResultFactory.buildFailResult("该用户已被禁用");
            }
            return ResultFactory.buildSuccessResult(username);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }
    }

    /**
     * 用户注册功能
     * @param user 要注册的用户信息
     * @return 封装的是否注册成功
     */
    @PostMapping("/api/register")
    public Result register(@RequestBody User user) {
        int status = userService.register(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }

    /**
     * 退出登录
     * @return 成功登出的封装消息
     */
    @GetMapping("/api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("成功登出");
    }

    /**
     * 身份认证
     * @return 成功认证的消息字符串
     */
    @GetMapping("/api/authentication")
    public String authentication() {
        return "身份认证成功";
    }

    /**
     * 通过登录用户名查找用户账号
     * @param requestUser 用户身份凭据
     * @return 封装的用户名
     */
    @CrossOrigin
    @RequestMapping("/api/info/username")
    public Result loggedUserUsername(@RequestBody User requestUser) {
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());
        return ResultFactory.buildSuccessResult(userService.findByUsername(username).getUsername());


    }

    /**
     * 通过登录用户查找用户姓名
     * @param requestUser 用户身份凭据
     * @return 封装的用户姓名
     */
    @CrossOrigin
    @RequestMapping("/api/info/name")
    public Result loggedUserName(@RequestBody User requestUser) {
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());
        return ResultFactory.buildSuccessResult(userService.findByUsername(username).getName());


    }
}
