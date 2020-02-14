package com.shencangblue.design.icrs;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController  {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String helloController(){
        return "hello world";
    }
}