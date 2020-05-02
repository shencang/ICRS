package com.shencangblue.design.icrs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//加入这个注解，Demo就会进行持久化了，在这里没有对@Table进行配置，请自行配置。
@Table(name = "class_room")
public class ClassRoom {
    @Id
    @GeneratedValue
    private long roomId;//房间iD
    private int roomNum;//房间号码
    private String roomName;//房间名
    private int capacity;//容量
    private int status;//状态
    private String position;//位置
    private String description;// 描述




    public ClassRoom(){}

    public ClassRoom(long roomId,int roomNum,String roomName,int capacity,int status,String description,String position){
        this.roomId= roomId;
        this.roomNum=roomNum;
        this.roomName =roomName;
        this.capacity =capacity;
        this.status = status;
        this.description= description;
        this.position= position;
    }


    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
