package com.shencangblue.design.icrs.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController  {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String helloController(){
        return "一级测试！";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String firstPage(){return "首页";}


}