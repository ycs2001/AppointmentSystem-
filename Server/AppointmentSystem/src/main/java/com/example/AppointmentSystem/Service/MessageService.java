package com.example.AppointmentSystem.Service;

import com.example.AppointmentSystem.Dao.MessageDao;
import com.example.AppointmentSystem.Entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;

    public List<MessageEntity> queryLimit(Integer currentPage, Integer pageSize){
        return messageDao.queryLimit(currentPage,pageSize);
    }

    public Integer getTotalNumber(){
        return messageDao.getTotalNumber();
    }

    public Integer updateMessage(MessageEntity messageEntity){
        return messageDao.updateMessage(messageEntity);
    }

    public Integer addMessage(MessageEntity messageEntity){
        return messageDao.addMessage(messageEntity);
    }

    public Integer deleteMessage(String activity_name){
        return messageDao.deleteMessage(activity_name);
    }




}
