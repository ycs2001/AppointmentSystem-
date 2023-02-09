package com.example.AppointmentSystem.Dao;

import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.LogEntity;
import com.example.AppointmentSystem.Entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageDao {

    List<MessageEntity> queryLimit(Integer currentPage, Integer pageSize);

    Integer getTotalNumber();

    Integer updateMessage(MessageEntity messageEntity);

    Integer addMessage(MessageEntity messageEntity);

    Integer deleteMessage(String activity_name);

}
