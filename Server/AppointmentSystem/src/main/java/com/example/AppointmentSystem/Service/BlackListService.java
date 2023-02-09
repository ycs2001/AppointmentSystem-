package com.example.AppointmentSystem.Service;


import com.example.AppointmentSystem.Dao.BlackListDao;
import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListService {
    @Autowired
    private BlackListDao blackListDao;

    public List<BlackListEntity> queryLimit(Integer currentPage, Integer pageSize){
        return blackListDao.queryLimit(currentPage,pageSize);
    }

    public List<BlackListEntity> getByLike(BlackListEntity blackListEntity) { return blackListDao.getByLike(blackListEntity);}

    public Integer getTotalNumber(){
        return blackListDao.getTotalNumber();
    }

    public Integer addBlackList(BlackListEntity blackListEntity){
        return blackListDao.addBlackList(blackListEntity);
    }

    public Integer updateBlackList(BlackListEntity blackListEntity){
        return blackListDao.updateBlackList(blackListEntity);
    }

    public Integer deleteBlackList(String id_card_number){
        return blackListDao.deleteBlackList(id_card_number);
    }

}
