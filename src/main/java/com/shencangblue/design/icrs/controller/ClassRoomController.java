package com.shencangblue.design.icrs.controller;

import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.service.ClassRoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/class")
public class ClassRoomController {
    @Resource
    private ClassRoomService classRoomService;

    @RequestMapping("/save")
    public String save(){
        ClassRoom classRoom = new ClassRoom();
        classRoom.setRoomName("测试");
        classRoom.setDescription("test");
        classRoom.setCapacity(20);
        classRoom.setStatus(1);
        classRoomService.save(classRoom);
        return "数据添加成功!";
    }
    @RequestMapping("/delete")
    public String delete(){
        classRoomService.delete(2L);
        return  "删除成功!";
    }

    @RequestMapping("/all")
    public Iterable<ClassRoom> getAll(){
        return classRoomService.getAll();
    }

    @RequestMapping("/update")
    public String update(){
        return classRoomService.update(3L,classRoomService.getById(3L))!=null?"sec":"fal";
    }

}
