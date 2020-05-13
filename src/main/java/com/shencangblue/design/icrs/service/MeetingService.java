package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.MeetingDao;
import com.shencangblue.design.icrs.model.Meeting;
import com.shencangblue.design.icrs.result.ResultFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class MeetingService {

    @Resource
    MeetingDao meetingDao;

    @Transactional
    public void saveAll(Iterable<Meeting> meetings){
        meetingDao.saveAll(meetings);
    }

    @Transactional
    public boolean save(Meeting meeting){

        meetingDao.save(meeting);
        return true;
    }
    @Transactional
    public void delete(Long id){
        meetingDao.deleteById(id);
    }

    @Transactional
    public Meeting getById(Long id){
        return meetingDao.findById(id).orElse(null);
    }

    @Transactional
    public Iterable<Meeting> getAll(){
        return meetingDao.findAll();
    }

    @Transactional
    public Iterable<Meeting> findAllByRoomId(long id){
        return  meetingDao.findAllByRoomId(id);
    }

    @Transactional
    public Iterable<Meeting> findAllByStuId(String username){
        return  meetingDao.findAllByStuName(username);
    }
    @Transactional
    public Iterable<Meeting> findAllByStuIdUsable(String username){
        return  meetingDao.findAllByStuNameAndStatus(username,1);
    }
    @Transactional
    public Iterable<Meeting> findAllByStuIdCancel(String username){
        return  meetingDao.findAllByStuNameAndCanceledTimeNotNull(username);
    }
    @Transactional
    public Iterable<Meeting> findAllByStuIdTimeout(String username){
        return  meetingDao.findAllByStuNameAndStatus(username,-1);
    }


    @Transactional
    public int CountByAllMeeting(){
        Iterator<?> it = meetingDao.findAll().iterator();
        int count=0;
        while (it.hasNext()){
            it.next();
            count++;
        }
        return count;
    }
    @Transactional
    public int CountByAllMeetingUsable(){
        return meetingDao.countByStatus(1);
    }
    @Transactional
    public int CountByAllMeetingCancelAndTimeout(){
        return meetingDao.countByStatus(0)+meetingDao.countByStatus(-1);
    }

    @Transactional
    public Iterable<Meeting> findAllByStartTimeBetweenAndStatusGreaterThan(Timestamp beginTime, Timestamp overTime,int status){
        return meetingDao.findAllByStartTimeBetweenAndStatusGreaterThan(beginTime,overTime,status);
    }

    @Transactional
    public Iterable<Meeting> findAllByStartTimeBetween(Timestamp beginTime, Timestamp overTime){
        return meetingDao.findAllByStartTimeBetween(beginTime,overTime);
    }
    @Transactional
    public Iterable<Meeting> findAllByStartTimeAfterAndEndTimeBefore(Timestamp newTime, Timestamp nowTime1){
        return meetingDao.findAllByStartTimeAfterAndEndTimeBefore(newTime,nowTime1);
    }
    @Transactional
    public Iterable<Meeting> findAllByEndTimeBefore(Timestamp newTime){
        return meetingDao.findAllByEndTimeBefore(newTime);
    }

    /**
     * 查询七天内所有用户会议所有教室预约情况-重新封装模式
     * @return 预约情况
     */
    @Transactional
    public Iterable<Meeting> querySevenDayMeetOfUser(String username){
            Timestamp nowTime = new Timestamp(new Date().getTime());
            Timestamp newTime = new Timestamp(new Date().getTime());
            newTime.setDate(nowTime.getDate()+7);
            System.out.println(username);
        System.out.println(nowTime);
        System.out.println(newTime);
        return meetingDao.findAllByStuNameAndStartTimeBetweenAndStatus(username,nowTime,newTime,1);
    }

    /**
     * 依照状态查询活动-重新封装模式
     * @return 预约情况
     */
    @Transactional
    public Iterable<Meeting> findAllByStatus(int status){
        return meetingDao.findAllByStatus(status);
    }


    /**
     * 依照会议时间是否冲突-重新封装模式
     * @return 是否冲突
     */
    @Transactional
    public boolean checkTimeConflict(Meeting meeting){
        if (meetingDao.findAllByEndTimeBetweenAndRoomIdAndStatusGreaterThan(meeting.getStartTime(),meeting.getEndTime(),meeting.getRoomId(),0).size()!=0){
            System.out.println("startTime error");
            return false;
        }else {
            if (meetingDao.findAllByEndTimeBetweenAndRoomIdAndStatusGreaterThan(meeting.getStartTime(),meeting.getEndTime(),meeting.getRoomId(),0).size()!=0){
                System.out.println("endTime error");
                return false;
            }else {
                System.out.println("check startTime and endTime");
                return meetingDao.findAllByEndTimeBetweenAndRoomIdAndStatusGreaterThan(meeting.getStartTime(), meeting.getEndTime(),meeting.getRoomId(),0).size() == 0;
            }
        }
    }

    /**
     * 查询指定用户可用活动中接近开始的那一个
     * @param newTime 要查询的预约时间
     * @param endTime 最多可接受时间，为当前时间加六个小时
     * @param status 活动状态
     * @param username 用户ID
     * @return 具体活动
     */
    @Transactional
    public Meeting meetingTimeVerification(Timestamp newTime,Timestamp endTime,int status,String username){
        return meetingDao.findByStartTimeAfterAndEndTimeBeforeAndStatusGreaterThanAndStuName(newTime,endTime,status,username);
    }
}
