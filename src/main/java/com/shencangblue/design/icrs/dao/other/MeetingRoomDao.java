package com.shencangblue.design.icrs.dao.other;

import com.shencangblue.design.icrs.model.other.MeetingRoom;
import org.springframework.data.repository.CrudRepository;

/*

 * 在CrudRepository自带常用的crud方法.

 * 这样一个基本dao就写完了.

 */
public interface MeetingRoomDao extends CrudRepository<MeetingRoom,Long> {


}
