package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.model.Meeting;
import com.shencangblue.design.icrs.model.User;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.MeetingService;
import com.shencangblue.design.icrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class MeetingController {
    @Resource
    MeetingService meetingService;
    @Resource
    UserService userService;


    @RequestMapping("/meeting/save")
    public Result save(@RequestBody Meeting meeting){
        meetingService.save(meeting);
        if (meetingService.getById(meeting.getMeetingId())!=null){
            return ResultFactory.buildSuccessResult("添加成功");
        }
        return ResultFactory.buildFailResult("添加失败");
    }

    @RequestMapping("/meeting/delete")
    public Meeting delete(@RequestBody Meeting meeting){
        System.out.println(meeting.getRoomId());
        meetingService.delete((long) meeting.getRoomId());
        return meeting;
    }

    @RequestMapping("/meeting")
    public Iterable<Meeting> getAll(){
        return meetingService.getAll();
    }

    @RequestMapping("/meeting/count")
    public Result getAllCount(){
        return ResultFactory.buildSuccessResult(meetingService.CountByAllMeeting());
    }

    @RequestMapping("/meeting/get/user")
    public Result getAllMeetingByUsername(@RequestBody User requestUser){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuId(userService.findByUsername(requestUser.getUsername()).getUsername()));
    }
    @RequestMapping("/meeting/get/admin")
    public Result getAllMeetingByAdmin(){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuId("admin"));
    }

}
