package com.shencangblue.design.icrs.controller;


import com.shencangblue.design.icrs.model.other.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController  {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String helloController(){
        return "一级测试！";
    }

    @RequestMapping(value = "getEE",method = RequestMethod.GET)
    public Employee  getEE(){
        Employee employee = new Employee();
        employee.setUsername("1");
        employee.setPassword("1233");
        return employee;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String firstPage(){return "首页";}


}