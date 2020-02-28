package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.UserRepository;
import com.shencangblue.design.icrs.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class UserService {
    @Resource
    private UserRepository userRepository;

    @Transactional
    public void  add(User user){
        userRepository.save(user);
    }

    @Transactional
    public User getById(Long id){
        return userRepository.findById(id).orElse(null);
    }

}
