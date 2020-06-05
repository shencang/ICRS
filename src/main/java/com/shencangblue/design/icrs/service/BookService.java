package com.shencangblue.design.icrs.service;


import com.shencangblue.design.icrs.dao.BookDAO;
import com.shencangblue.design.icrs.model.study.Book;
import com.shencangblue.design.icrs.model.study.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

    /**
     * 获取全部书籍，按照ID排序
     * @return 书籍列表
     */
    public List<Book> list() {
        return bookDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * 新建书籍或者修改书籍
     * @param book 新增书籍和修改书籍
     */
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    /**
     * 删除书籍
     * @param id 要删除书籍的ID
     */
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    /**
     * 按照分类获取书籍
     * @param cid 分类编号
     * @return 返回分类下所有的书籍
     */
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    /**
     * 查找功能
     * @param keywords 查找关键词
     * @return 查找到的书籍
     */
    public List<Book> Search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }
}
