package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.UserRepository;
import com.shencangblue.design.icrs.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
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

    @Transactional
    public boolean isExist(String username){
        User user =userRepository.findByUsername(username);
        return null!=user;
    }
    @Transactional
    public User getByName(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User nameAndPwd(String username,String password){
        return userRepository.getByUsernameAndPassword(username,password);
    }
}
