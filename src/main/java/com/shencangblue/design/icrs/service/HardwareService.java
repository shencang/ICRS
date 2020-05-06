package com.shencangblue.design.icrs.service;

import com.shencangblue.design.icrs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class HardwareService {
    @Autowired
    UserService userService;
    @Autowired
    MeetingService meetingService;


    /**
     * 读取卡号确认是否允许进入房间
     * @param cardId 用户卡号
     * @return 是否允许
     */
    @Transactional
    public boolean ConferenceRFID(String cardId){
        User user = userService.getByCard(cardId);
        Timestamp nowTime = new Timestamp(new Date().getTime());
        nowTime.setMinutes(nowTime.getMinutes()-5);
        Timestamp endTime = new Timestamp(new Date().getTime());
        endTime.setHours(endTime.getHours()+6);
        if (meetingService.meetingTimeVerification(nowTime,endTime
                ,0,user.getUsername())!=null){
            return true;
        }else {
            return false;
        }
    }
}
