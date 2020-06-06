package com.shencangblue.design.icrs.service;


import com.shencangblue.design.icrs.dao.JotterArticleDAO;
import com.shencangblue.design.icrs.model.study.JotterArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class JotterArticleService {
    @Autowired
    JotterArticleDAO jotterArticleDAO;

    /**
     * 获取对于页数的内容
     * @param page 页码
     * @param size 数量
     * @return 对应页码的内容
     */
    public Page list(int page, int size) {
        return jotterArticleDAO.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")));
    }

    /**
     * 用ID获取指定内容
     * @param id 要查找的ID
     * @return 查找到的内容
     */
    public JotterArticle findById(int id) {
        return jotterArticleDAO.findById(id);
    }

    /**
     * 新增或者修改内容
     * @param article 新增与修改的内容
     */
    public void addOrUpdate(JotterArticle article) {
        jotterArticleDAO.save(article);
    }

    /**
     * 输出指定的内容
     * @param id 要删除的内容id
     */
    public void delete(int id) {
        jotterArticleDAO.deleteById(id);
    }

}
