package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.ClassRoomService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class ClassRoomController {
    @Resource
    private ClassRoomService classRoomService;

    @CrossOrigin
    @RequestMapping("/rooms/save")
    public ClassRoom save(@RequestBody ClassRoom classRoom){
        classRoomService.save(classRoom);
        return classRoom;
    }
    @CrossOrigin
    @RequestMapping("/rooms/delete")
    public ClassRoom delete(@RequestBody ClassRoom classRoom){
        System.out.println(classRoom.getRoomId());
        classRoomService.delete(classRoom.getRoomId());
        return classRoom;
    }
    @CrossOrigin
    @RequestMapping("/rooms")
    public Result getAll(){
        return ResultFactory.buildSuccessResult(classRoomService.getAll());
    }

    @CrossOrigin
    @RequestMapping("/rooms/count")
    public Result getAllCount(){
            return ResultFactory.buildSuccessResult(classRoomService.CountByAllClassRoom());
    }
    @CrossOrigin
    @RequestMapping("/rooms/used-count")
    public Result getUsedCount(){
        return ResultFactory.buildSuccessResult(classRoomService.CountByUsedClassRoom(1));
    }

    @CrossOrigin
    @RequestMapping("/rooms/unused-count")
    public Result getUnusedCount(){
        return ResultFactory.buildSuccessResult(classRoomService.CountByUsedClassRoom(-1));
    }
    @CrossOrigin
    @RequestMapping("/rooms/usable-rooms")
    public Result getUsableRooms(){
        return ResultFactory.buildSuccessResult(classRoomService.findAllUsableRooms(0));
    }



    @CrossOrigin
    @RequestMapping("/rooms/update")
    public String update(){
        return classRoomService.update(3L,classRoomService.getById(3L))!=null?"sec":"fal";
    }


    @CrossOrigin
    @RequestMapping("/rooms/capacity/{capacity}/rooms")
    public Iterable<ClassRoom> findAllByCapacity(@PathVariable("capacity") int capacity){
        System.out.println(capacity);
        if (0==capacity){
            return classRoomService.getAll();
        }else {
            return classRoomService.findAllByCapacity(capacity);
        }
    }
    @CrossOrigin
    @RequestMapping("/search")
    public Iterable<ClassRoom> searchResult(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)){
            return classRoomService.getAll();
        }
        else {
            return classRoomService.search(keywords);
        }
    }

    @RequestMapping("/room/idName")
    public Long getRoomIdByName(@RequestParam("roomName") String roomName){
        System.out.println(classRoomService.getRoomByName(roomName).getRoomId());
        return classRoomService.getRoomByName(roomName).getRoomId();
    }

    /**
     * 检查教室是否用占用，进行状态检查并修改-重新封装模式
     * @return 预约情况
     */
    @RequestMapping("/checkRoomIsWillUse")
    public Result checkRoomIsWillUse(){
        return ResultFactory.buildSuccessResult(classRoomService.checkRoomIsWillUse());
    }



}
