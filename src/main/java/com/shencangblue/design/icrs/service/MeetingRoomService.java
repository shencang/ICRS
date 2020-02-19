package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.MeetingRoomRepository;
import com.shencangblue.design.icrs.model.MeetingRoom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class MeetingRoomService {

    @Resource
    private MeetingRoomRepository meetingRoomRepository;
    @Transactional
    public  void save(MeetingRoom meetingRoom){
        meetingRoomRepository.save(meetingRoom);
    }

}
