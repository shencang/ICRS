package com.shencangblue.design.icrs.dao;

import com.shencangblue.design.icrs.model.MeetingRoom;
import org.springframework.data.repository.CrudRepository;

/*

 * 在CrudRepository自带常用的crud方法.

 * 这样一个基本dao就写完了.

 */
public interface MeetingRoomRepository extends CrudRepository<MeetingRoom,Long> {
}
