package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.study.JotterArticle;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class HardwareController {
    @Autowired
    HardwareService hardwareService;

    /**
     * 以用户卡号获取用户是否有预约
     * @param cardId 用户卡号
     * @return 用户是是否有预约
     */
    //@PostMapping("card/getById")
    @RequestMapping("card/getById")
    public boolean saveArticle(@RequestParam("id") String cardId) {
        System.out.println(cardId);
        return  hardwareService.ConferenceRFID(cardId);
    }
}
