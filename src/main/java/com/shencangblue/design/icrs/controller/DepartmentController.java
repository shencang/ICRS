package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.Department;
import com.shencangblue.design.icrs.model.Meeting;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/department")
    public Result getAll(){
        return ResultFactory.buildSuccessResult(departmentService.getAll());
    }

    @RequestMapping("/department/delete")
    public Result delete(@RequestBody Department department){
        departmentService.delete(department.getDepartmentId());
        return ResultFactory.buildSuccessResult("success");
    }
    @RequestMapping("/department/save")
    public Result save(@RequestBody Department department){
        departmentService.save(department);
        if (departmentService.getById(department.getDepartmentId())!=null){
            return ResultFactory.buildSuccessResult("添加成功");
        }
        return ResultFactory.buildFailResult("添加失败");
    }
}
