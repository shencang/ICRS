package com.shencangblue.design.icrs.service;


import com.shencangblue.design.icrs.dao.CategoryDAO;
import com.shencangblue.design.icrs.model.study.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    /**
     * 获取所有分类
     * @return 所有分类
     */
    public List<Category> list() {
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * 获取指定的分类
     * @param id 要获取的分类的ID
     * @return 对应的分类
     */
    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
}

