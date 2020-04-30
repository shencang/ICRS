package com.shencangblue.design.icrs.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue
    private long meetingId;//会议ID
    private String meetingName;//会议名称
    private int roomId;//会议室ID
    private int reservationIsTid;//预订为Tid
    private int numberOfParticipants;//参加人数
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp startTime;//开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp endTime;//结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp reservationTime;//预定时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",  timezone="GMT+8")
    private Timestamp canceledTime;//取消时间
    private String description;//描述
    private int status;//状态
    private String roomName;//房间名
    private String stuName;//学生名
    private String canceledReason;//取消原因

    public Meeting(){

    }
    public Meeting(long meetingId,String meetingName,int roomId,int reservationIsTid,int numberOfParticipants,
                   Timestamp startTime,Timestamp endTime,Timestamp reservationTime,Timestamp canceledTime,
                   String description,int status,String roomName,String stuName ,String canceledReason){
        this.meetingId =meetingId;
        this.meetingName=meetingName;
        this.roomId=roomId;
        this.reservationIsTid= reservationIsTid;
        this.numberOfParticipants =numberOfParticipants;
        this.startTime =startTime;
        this.endTime =endTime;
        this.reservationTime=reservationTime;
        this.canceledTime =canceledTime;
        this.description =description;
        this.status=status;
        this.roomName=roomName;
        this.stuName=stuName;
        this.canceledReason=canceledReason;


    }

    public long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getReservationIsTid() {
        return reservationIsTid;
    }

    public void setReservationIsTid(int reservationIsTid) {
        this.reservationIsTid = reservationIsTid;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Timestamp reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Timestamp getCanceledTime() {
        return canceledTime;
    }

    public void setCanceledTime(Timestamp canceledTime) {
        this.canceledTime = canceledTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getEmpName() {
        return stuName;
    }

    public void setEmpName(String empName) {
        this.stuName = empName;
    }

    public String getCanceledReason() {
        return canceledReason;
    }

    public void setCanceledReason(String canceledReason) {
        this.canceledReason = canceledReason;
    }
}
