package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.ClassRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassRoomDao extends CrudRepository<ClassRoom,Long> {

    List<ClassRoom> findAllByCapacity(int capacity );

    List<ClassRoom> findAllByRoomNameLikeOrPositionLike(String key1,String key2);
}
