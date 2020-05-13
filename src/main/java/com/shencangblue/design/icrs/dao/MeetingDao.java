package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.model.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface MeetingDao extends CrudRepository<Meeting,Long> {
    List<Meeting> findAllByRoomId(long id);

    List<Meeting> findAllByStuName(String stuName);

    List<Meeting> findAllByRoomName(String roomName);

    List<Meeting> findAllByStuNameAndStatus(String stuName,int status);

    List<Meeting> findAllByStuNameAndCanceledTimeNotNull(String stuName);

    int countByStatus(int status);

    List<Meeting> findAllByStartTimeBetweenAndStatusGreaterThan(Timestamp beginTime,Timestamp overTime,int status);

    List<Meeting> findAllByStartTimeBetween(Timestamp beginTime,Timestamp overTime);

    List<Meeting> findAllByStartTimeAfterAndEndTimeBefore(Timestamp newTime,Timestamp newTime1);

    List<Meeting> findAllByEndTimeBefore(Timestamp newTime);

    List<Meeting> findAllByStuNameAndStartTimeBetweenAndStatus(String stuName,Timestamp beginTime,Timestamp overTime,int status);

    List<Meeting> findAllByStatus(int status);

    List<Meeting> findAllByEndTimeBetweenAndStatusGreaterThan(Timestamp beginTime,Timestamp overTime,int status);

    List<Meeting> findAllByStartTimeBeforeAndEndTimeAfterAndStatusGreaterThan(Timestamp beginTime,Timestamp overTime,int status);

    Meeting findByStartTimeAfterAndEndTimeBeforeAndStatusGreaterThanAndStuName(Timestamp openTime,Timestamp endTime,int status,String empName);

    List<Meeting> findAllByEndTimeBetweenAndRoomIdAndStatusGreaterThan(Timestamp beginTime,Timestamp overTime,int RoomId,int status);
}
