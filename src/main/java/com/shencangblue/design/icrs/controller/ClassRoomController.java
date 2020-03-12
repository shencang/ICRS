package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
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
    public Iterable<ClassRoom> getAll(){
        return classRoomService.getAll();
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

}
