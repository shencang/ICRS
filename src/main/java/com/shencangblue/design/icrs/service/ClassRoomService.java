package com.shencangblue.design.icrs.service;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.model.Meeting;
import com.shencangblue.design.icrs.utils.BDAipBodyAnalysis;
import com.shencangblue.design.icrs.utils.FaceDetectionUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Service
public class ClassRoomService {
    @Resource
    ClassRoomDao classRoomDao;
    @Resource
    MeetingService meetingService;

    /**
     * 获取所有的教室
     * @return 所有的教室列表
     */
    @Transactional
    public Iterable<ClassRoom> findAll(){
        return classRoomDao.findAll();
    }

    /**
     * 新建或者保存新的教室
     * @param classRoom 要保存的和新建的教室
     */
    @Transactional
    public void save(ClassRoom classRoom){
        classRoomDao.save(classRoom);
    }

    /**
     * 删除指定的教室
     * @param id 教室的ID
     */
    @Transactional
    public void delete(Long id){
        classRoomDao.deleteById(id);
    }

    /**
     * 通过ID获取指定教室
     * @param id 教室的ID
     * @return 要查找的教室
     */
    @Transactional
    public ClassRoom getById(Long id){
       return classRoomDao.findById(id).orElse(null);
    }

    /**
     * 获取所有教室
     * @return 返回所有教室
     */
    @Transactional
    public Iterable<ClassRoom> getAll(){
        return classRoomDao.findAll();
}

    /**
     * 测试的更新方法
     * @param id 要修改的教室ID
     * @param classRoom 修改的相关数据
     * @return 修改成功的结果
     */
    @Transactional
    public ClassRoom update(Long id ,ClassRoom classRoom){
        classRoom.setRoomName("测试@@up");
        classRoom.setDescription("test@@up");
        classRoom.setCapacity(30);
        classRoom.setStatus(1);
        return classRoom;
    }

    /**
     * 获取相对于分类的教室
     * @param capacity 分类
     * @return 分类下的教室
     */
    @Transactional
    public Iterable<ClassRoom> findAllByCapacity(int capacity){
        return  classRoomDao.findAllByCapacity(capacity);
    }

    @Transactional
    public Iterable<ClassRoom> search(String keywords){
        return classRoomDao.findAllByRoomNameLikeOrPositionLike('%'+keywords+'%','%'+keywords+'%');
    }

    @Transactional
    public int CountByAllClassRoom(){
        Iterator<?> it = classRoomDao.findAll().iterator();
        int count=0;
        while (it.hasNext()){
            it.next();
            count++;
        }
        return count;
    }
    @Transactional
    public int CountByUsedClassRoom(int status){
        return classRoomDao.countAllByStatus(status);
    }

    @Transactional
    public Iterable<ClassRoom> findAllUsableRooms(int status){
     return classRoomDao.findAllByStatus(status);
    }

    @Transactional
    public ClassRoom getRoomByName(String roomName){
        return classRoomDao.getByRoomName(roomName);
    }

    /**
     * 检查教室是否用占用，进行状态检查并修改-重新封装模式
     * @return 预约情况
     */
    @Transactional
    public boolean checkRoomIsWillUse(){
        List<Integer> roomList = new ArrayList<>();
        for (Meeting meeting:meetingService.findAllByStatus(1)){
            roomList.add(meeting.getRoomId());
        }
        for (Meeting meeting:meetingService.findAllByStatus(2)){
            roomList.add(meeting.getRoomId());
        }
        for (ClassRoom classRoom:classRoomDao.findAll()){
            if (classRoom.getStatus()!=-1){
                classRoom.setStatus(0);
                classRoomDao.save(classRoom);
            }
        }
        HashSet<Integer> set=new LinkedHashSet<>(roomList);

        for (ClassRoom classRoom:classRoomDao.findAll()){
            for (int index:set){
                assert classRoom != null;
                if (classRoom.getRoomId()==index){
                    classRoom.setStatus(1);
                    classRoomDao.save(classRoom);
                }
            }
        }

        return true;
    }

    /**
     * 用于统计房间人数的方法-活体检测
     * @param roomId 房间ID
     * @return 人数
     */
    public int checkRoomNumberOfParticipants(long roomId) {
        //获取监控照片
        File image = getRoomMonitoringScreen(roomId);
        FaceDetectionUtils faceDetectionUtils = new FaceDetectionUtils();
        return faceDetectionUtils.liveDetection(image);
    }

    /**
     * 用于统计房间人数的方法-活体检测-前端传递文件类型
     * @param image 需要识别的照片
     * @return 人数
     */
    public int checkRoomNumberOfParticipants(File image) {
        //获取监控照片
        FaceDetectionUtils faceDetectionUtils = new FaceDetectionUtils();
        return faceDetectionUtils.liveDetection(image);
    }

    /**
     * 用于从监控系统获取截取的画面
     * @param roomId 房间ID
     * @return 截取的静态画面
     */
    public File getRoomMonitoringScreen(long roomId){
        //todo 未完成
        return new File("d:\\faceget.jpg");
    }

    /**
     * 百度人数统计接口
     * @param client 人体分析客户端
     * @param file 要分析图像文件
     */
    public String analysisPeople(AipBodyAnalysis client,File file){

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("show", "false");

        // 参数为本地路径
        String image = file.getAbsolutePath();
        JSONObject res = client.bodyNum(image, options);
        System.out.println(res.toString(2));
        return res.toString(2);
    }


}
