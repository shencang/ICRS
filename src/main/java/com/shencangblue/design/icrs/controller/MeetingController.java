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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MeetingController {
    @Resource
    MeetingService meetingService;
    @Resource
    UserService userService;
    Timestamp nowTime;
    Timestamp tomTime;


    @RequestMapping("/meeting/save")
    public Result save(@RequestBody Meeting meeting){
        meetingService.save(meeting);
        if (meetingService.getById(meeting.getMeetingId())!=null){
            return ResultFactory.buildSuccessResult("添加成功");
        }
        return ResultFactory.buildFailResult("添加失败");
    }

    @RequestMapping("/meeting/delete")
    public Result delete(@RequestBody Meeting meeting){
        System.out.println(meeting.getMeetingId());
        meetingService.delete(meeting.getMeetingId());
        return ResultFactory.buildSuccessResult("success");
    }

    @RequestMapping("/meeting")
    public Result getAll(){
        return ResultFactory.buildSuccessResult(meetingService.getAll());
    }

    @RequestMapping("/meeting/count")
    public Result getAllCount(){
        return ResultFactory.buildSuccessResult(meetingService.CountByAllMeeting());
    }

    @RequestMapping("/meeting/get/user")
    public Result getAllMeetingByUsername(@RequestBody User requestUser){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuId(requestUser.getUsername()));
    }
    @RequestMapping("/meeting/get/admin")
    public Result getAllMeetingByAdmin(){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuId("admin"));
    }
    @RequestMapping("/meeting/get/user_used")
    public Result getAllMeetingByUsernameUsable(@RequestBody User requestUser){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuIdUsable(requestUser.getUsername()));
    }

    @RequestMapping("/meeting/cancel")
    public Result cancelMeeting(@RequestBody Meeting meeting){
        Meeting meeting_s = meetingService.getById(meeting.getMeetingId());
        meeting_s.setStatus(0);
        meeting_s.setCanceledTime(meeting.getCanceledTime());
        meeting_s.setCanceledReason(meeting.getCanceledReason());
        meetingService.save(meeting_s);
        return ResultFactory.buildSuccessResult("取消成功");
    }

    @RequestMapping("/meeting/get/user_cancel")
    public Result getAllMeetingByUsernameCanceled(@RequestBody User requestUser){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuIdCancel(requestUser.getUsername()));
    }
    @RequestMapping("/meeting/get/user_timeout")
    public Result getAllMeetingByUsernameTimeout(@RequestBody User requestUser){
        return ResultFactory.buildSuccessResult(meetingService.findAllByStuIdTimeout(requestUser.getUsername()));
    }

    @RequestMapping("/meeting/get/count/classify/usable")
    public Result getAllMeetingCountClassifyUsable(){
        return ResultFactory.buildSuccessResult(meetingService.CountByAllMeetingUsable());
    }
    @RequestMapping("/meeting/get/count/classify/c&t")
    public Result getAllMeetingCountClassifyCancelAndTimeout(){
        return ResultFactory.buildSuccessResult(meetingService.CountByAllMeetingCancelAndTimeout());
    }
    /**
     * 查询当前日期所有教室预约情况
     * @return 预约情况
     */
    @RequestMapping("/queryReservationOfCurrentDate")
    public Result QueryReservationOfCurrentDate(){
        //List<List<List<Integer>>> d2AList = new ArrayList<List<List<Integer>>>();
        List<int[]> list = new ArrayList<>();
       nowTime = new Timestamp(new Date().getTime());
       tomTime = new Timestamp(new Date().getTime());
        nowTime.setHours(0);
        nowTime.setSeconds(0);
        nowTime.setMinutes(0);
        nowTime.setNanos(0);
        tomTime.setHours(0);
        tomTime.setSeconds(0);
        tomTime.setMinutes(0);
        tomTime.setNanos(0);
        tomTime.setDate(tomTime.getDate()+1);
        int count=0;
        for (Meeting meeting :meetingService.findAllByStartTimeBetweenAndStatusGreaterThan(nowTime,tomTime,0)) {

            list.add(new int[]{count, meeting.getStartTime().getHours(),meeting.getNumberOfParticipants()});
            count++;

        }
        return ResultFactory.buildSuccessResult(list);
    }

    @RequestMapping("/queryReservationOfCurrentDateRoom")
    public Result QueryReservationOfCurrentDateRoom(){
        List<String> list = new ArrayList<>();
        nowTime = new Timestamp(new Date().getTime());
        tomTime = new Timestamp(new Date().getTime());
        nowTime.setHours(0);
        nowTime.setSeconds(0);
        nowTime.setMinutes(0);
        nowTime.setNanos(0);
        tomTime.setHours(0);
        tomTime.setSeconds(0);
        tomTime.setMinutes(0);
        tomTime.setNanos(0);
        tomTime.setDate(tomTime.getDate()+1);
        for (Meeting meeting :meetingService.findAllByStartTimeBetweenAndStatusGreaterThan(nowTime,tomTime,0)) {

            list.add(meeting.getRoomName());
;
        }
        return ResultFactory.buildSuccessResult(list);
    }

    @RequestMapping("/checkMeetBegin")
    public Result checkMeetBegin(){
        Iterable<Meeting> meetings = meetingService.findAllByStartTimeAfterAndEndTimeBefore(nowTime,nowTime);
        nowTime = new Timestamp(new Date().getTime());
        for (Meeting meeting:meetings){
            meeting.setStatus(2);
        }
        meetingService.saveAll(meetings);
        return ResultFactory.buildSuccessResult("更新状态成功");
    }


@RequestMapping("/checkMeetTimeout")
public Result checkMeetTimeout(){
    nowTime = new Timestamp(new Date().getTime());
    Iterable<Meeting> meetings = meetingService.findAllByEndTimeBefore(nowTime);
    for (Meeting meeting:meetings){
        meeting.setStatus(-1);
        System.out.println(meeting.getMeetingId()+" "+meeting.getStatus());
    }
    meetingService.saveAll(meetings);
    return ResultFactory.buildSuccessResult("更新状态成功");
}
}

