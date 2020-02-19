package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.MeetingRoom;
import com.shencangblue.design.icrs.service.MeetingRoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/room")
public class MeetingRoomController {

    @Resource
    private MeetingRoomService meetingRoomService;

    /**
     * 测试保存数据方法.
     * @return
     */
    @RequestMapping("/save")
    public String save(){
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setRoomName("eee");
        meetingRoom.setRoomNum(1);
        meetingRoomService.save(meetingRoom);
        return "ok.MeetingRoomController.save";
    }
}
