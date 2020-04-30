package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.Meeting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeetingDao extends CrudRepository<Meeting,Long> {
    List<Meeting> findAllByRoomId(long id);

    List<Meeting> findAllByStuName(String stuName);

    List<Meeting> findAllByRoomName(String roomName);



}
