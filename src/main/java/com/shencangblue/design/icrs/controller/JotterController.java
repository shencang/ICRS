package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.study.JotterArticle;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.JotterArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class JotterController {
    @Autowired
    JotterArticleService jotterArticleService;


    /**
     * 保存公告或者文章
     * @param article 公告和文件
     * @return 封装的保存成功消息
     */
    @PostMapping("api/admin/content/article")
    public Result saveArticle(@RequestBody @Valid JotterArticle article) {
        jotterArticleService.addOrUpdate(article);
        return ResultFactory.buildSuccessResult("保存成功");
    }

    /**
     * 分页功能
     * @param size 数量
     * @param page 页码数
     * @return 封装页面数据
     */
    @GetMapping("/api/article/{size}/{page}")
    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(jotterArticleService.list(page - 1, size));
    }

    /**
     * 查看指定ID的文章
     * @param id 文章、公告的iD
     * @return 封装的文章或者公告
     */
    @GetMapping("/api/article/{id}")
    public Result getOneArticle(@PathVariable("id") int id) {
        return ResultFactory.buildSuccessResult(jotterArticleService.findById(id));
    }

    /**
     * 删除文章或者公告
     * @param id 要删除的ID
     * @return 封装好的删除结果
     */
    @DeleteMapping("/api/admin/content/article/{id}")
    public Result deleteArticle(@PathVariable("id") int id) {
        jotterArticleService.delete(id);
        return ResultFactory.buildSuccessResult("删除成功");
    }
}
