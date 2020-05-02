package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.MeetingDao;
import com.shencangblue.design.icrs.model.Meeting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Iterator;

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
}
