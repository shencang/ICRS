package com.shencangblue.design.icrs.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController  {
    /**
     * 测试用的控制器
     * @return 参数字符串
     */
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String helloController(){
        return "一级测试！";
    }

    /**
     * 后端首页测试代码
     * @return 测试字符串
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String firstPage(){return "首页";}


}