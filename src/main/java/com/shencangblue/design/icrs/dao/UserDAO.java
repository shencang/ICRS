package com.shencangblue.design.icrs.dao;


import com.shencangblue.design.icrs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    User findByCardId(String cardId);
}
