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

    /**
     * 获取所有组织
     * @return 封装好的组织样式
     */
    @RequestMapping("/department")
    public Result getAll(){
        return ResultFactory.buildSuccessResult(departmentService.getAll());
    }

    /**
     * 删除组织
     * @param department 组织
     * @return 封装的删除成功的提示
     */
    @RequestMapping("/department/delete")
    public Result delete(@RequestBody Department department){
        departmentService.delete(department.getDepartmentId());
        return ResultFactory.buildSuccessResult("success");
    }

    /**
     * 保存或者新增组织
     * @param department 组织
     * @return 封装好的添加或者修改提示
     */
    @RequestMapping("/department/save")
    public Result save(@RequestBody Department department){
        departmentService.save(department);
        if (departmentService.getById(department.getDepartmentId())!=null){
            return ResultFactory.buildSuccessResult("添加成功");
        }
        return ResultFactory.buildFailResult("添加失败");
    }
}
