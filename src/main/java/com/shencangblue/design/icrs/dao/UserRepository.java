package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
