package com.shencangblue.design.icrs.dao;


import com.shencangblue.design.icrs.model.study.Book;
import com.shencangblue.design.icrs.model.study.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookDAO extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
