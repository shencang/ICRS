package com.shencangblue.design.icrs.controller;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import com.shencangblue.design.icrs.service.ClassRoomService;
import com.shencangblue.design.icrs.utils.BDAipBodyAnalysis;
import com.shencangblue.design.icrs.utils.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ClassRoomController {
    @Resource
    private ClassRoomService classRoomService;

    /**
     * 保存新的或者修改教室
     * @param classRoom 教室
     * @return 保存的新房间
     */
    @CrossOrigin
    @RequestMapping("/rooms/save")
    public ClassRoom save(@RequestBody ClassRoom classRoom){
        classRoomService.save(classRoom);
        return classRoom;
    }

    /**
     * 删除教室
     * @param classRoom 教室
     * @return 删除的教室
     */
    @CrossOrigin
    @RequestMapping("/rooms/delete")
    public ClassRoom delete(@RequestBody ClassRoom classRoom){
        System.out.println(classRoom.getRoomId());
        classRoomService.delete(classRoom.getRoomId());
        return classRoom;
    }

    /**
     * 获得所有的房间列表
     * @return 封装获得所有房间
     */
    @CrossOrigin
    @RequestMapping("/rooms")
    public Result getAll(){
        return ResultFactory.buildSuccessResult(classRoomService.getAll());
    }

    /**
     * 获取所有的房间数量
     * @return 封装的房间数
     */
    @CrossOrigin
    @RequestMapping("/rooms/count")
    public Result getAllCount(){
            return ResultFactory.buildSuccessResult(classRoomService.CountByAllClassRoom());
    }

    /**
     * 获取正在使用的房间数
     * @return 封装的房间数
     */
    @CrossOrigin
    @RequestMapping("/rooms/used-count")
    public Result getUsedCount(){
        return ResultFactory.buildSuccessResult(classRoomService.CountByUsedClassRoom(1));
    }

    /**
     * 不可用的房间数量
     * @return 封装的房间数目
     */
    @CrossOrigin
    @RequestMapping("/rooms/unused-count")
    public Result getUnusedCount(){
        return ResultFactory.buildSuccessResult(classRoomService.CountByUsedClassRoom(-1));
    }

    /**
     * 获取没有预约的房间
     * @return 封装的房间
     */
    @CrossOrigin
    @RequestMapping("/rooms/usable-rooms")
    public Result getUsableRooms(){
        return ResultFactory.buildSuccessResult(classRoomService.findAllUsableRooms(0));
    }


    /**
     * 修改指定的房间数据
     * @return 修改结果
     */
    @CrossOrigin
    @RequestMapping("/rooms/update")
    public String update(){
        return classRoomService.update(3L,classRoomService.getById(3L))!=null?"sec":"fal";
    }


    /**
     * 获取不同的分类的房间
     * @param capacity 分类的依据：房间容纳人数
     * @return 教室列表
     */
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

    /**
     * 查询功能
     * @param keywords 要查询的关键字
     * @return 查询到的教室
     */
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

    /**
     * 通过教室名字获取教室Id
     * @param roomName  教室名字
     * @return 教室的Id
     */
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

    /**
     * 用于统计房间人数的方法-活体检测-非前端返回类型
     * @param classRoom 房间Id
     * @return 封装的人数
     */

    @RequestMapping("/checkRoomNumber")
    public Result checkRoomNumberOfParticipants(ClassRoom classRoom){

        return ResultFactory.buildSuccessResult(classRoomService.checkRoomNumberOfParticipants(classRoom.getRoomId()));
    }

    /**
     * 用于统计房间人数的方法-活体检测-前端返回类型
     * @param file 教室的图像
     * @return 封装的人数
     */
    @PostMapping("/classroomInfo/info")
    public String coversUpload(MultipartFile file) {
        AipBodyAnalysis client =BDAipBodyAnalysis.getClient();
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
//            String imgURL = "http://localhost:8443/api/file/" + f.getName();
//            return imgURL;
            return classRoomService.analysisPeople(client ,f);
        } catch (IOException e) {
            e.printStackTrace();
            return "-1";
        }
    }


}
