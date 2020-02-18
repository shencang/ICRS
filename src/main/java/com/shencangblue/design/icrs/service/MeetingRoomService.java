package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.model.MeetingRoom;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class MeetingRoomService {

    @Resource
    private MeetingRoomService meetingRoomService;
    @Transactional
    public  void save(MeetingRoom meetingRoom){
        meetingRoomService.save(meetingRoom);
    }

}
