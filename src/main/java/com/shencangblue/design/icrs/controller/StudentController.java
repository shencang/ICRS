package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.Student;

import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.StudentService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;


@Controller
public class StudentController {
    @Resource
    StudentService studentService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody Student requestStudent) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String studentIdName = requestStudent.getStudentIdName();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(studentIdName,requestStudent.getPassword());
        try{
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        }catch (AuthenticationException e){
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }

    }
    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "api/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message= "成功登出账号";
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "api/register-stu")
    @ResponseBody
    public Result register(@RequestBody Student student) {
        String studentIdName = student.getStudentIdName();
        String password = student.getPassword();
        studentIdName = HtmlUtils.htmlEscape(studentIdName);
        student.setStudentIdName(studentIdName);

        boolean exist = studentService.isExist(studentIdName);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        student.setSalt(salt);
        student.setPassword(encodedPassword);
        studentService.save(student);

        return ResultFactory.buildSuccessResult(student);
    }

}

