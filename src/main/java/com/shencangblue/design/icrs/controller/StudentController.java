package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.Student;

import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
        studentIdName = HtmlUtils.htmlEscape(studentIdName);

        Student student = studentService.studentIdAndPwd(studentIdName, requestStudent.getPassword());
        if (null == student) {
            String message = "账号密码错误";
            System.out.println("test");
          // return new Result(400);
        } else {
          //  return new Result(200);
        }
        return null;
    }

    @CrossOrigin
    @PostMapping(value = "api/register-stu")
    @ResponseBody
    public Result registerStu(@RequestBody Student student) {
        int status = studentService.reg(student);
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
}

