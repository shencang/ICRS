package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
import com.shencangblue.design.icrs.model.Meeting;
import com.shencangblue.design.icrs.utils.FaceDetectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.util.*;


@Service
public class ClassRoomService {
    @Resource
    ClassRoomDao classRoomDao;
    @Resource
    MeetingService meetingService;

    @Transactional
    public Iterable<ClassRoom> findAll(){
        return classRoomDao.findAll();
    }

    @Transactional
    public void save(ClassRoom classRoom){
        classRoomDao.save(classRoom);
    }
    @Transactional
    public void delete(Long id){
        classRoomDao.deleteById(id);
    }

    @Transactional
    public ClassRoom getById(Long id){
       return classRoomDao.findById(id).orElse(null);
    }

    @Transactional
    public Iterable<ClassRoom> getAll(){
        return classRoomDao.findAll();
}

    @Transactional
    public ClassRoom update(Long id ,ClassRoom classRoom){
        classRoom.setRoomName("测试@@up");
        classRoom.setDescription("test@@up");
        classRoom.setCapacity(30);
        classRoom.setStatus(1);
        return classRoom;
    }
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
     * 用于从监控系统获取截取的画面
     * @param roomId 房间ID
     * @return 截取的静态画面
     */
    public File getRoomMonitoringScreen(long roomId){
        //todo 未完成
        return new File("d:\\faceget.jpg");
    }

}
