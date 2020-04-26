package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.dao.ClassRoomDao;
import com.shencangblue.design.icrs.model.ClassRoom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Iterator;


@Service
public class ClassRoomService {
    @Resource
    ClassRoomDao classRoomDao;

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
}
