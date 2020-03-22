package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.other.MeetingRoomDao;
import com.shencangblue.design.icrs.model.other.MeetingRoom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class MeetingRoomService {

    @Resource
    private MeetingRoomDao meetingRoomDao;
    @Transactional
    public  void save(MeetingRoom meetingRoom){
        meetingRoomDao.save(meetingRoom);
    }

    @Transactional
    public  MeetingRoom getById(Long id){
        return meetingRoomDao.findById(id).orElse(null);

    }
    @Transactional
    public Iterable<MeetingRoom> getAll(){
        return meetingRoomDao.findAll();
    }
    @Transactional
    public void update(MeetingRoom meetingRoom){
        meetingRoomDao.save(meetingRoom);
    }
}
