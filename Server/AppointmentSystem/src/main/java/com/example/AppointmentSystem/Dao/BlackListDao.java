package com.example.AppointmentSystem.Dao;
import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlackListDao {

    List<BlackListEntity> queryLimit(Integer currentPage, Integer pageSize);
    List<BlackListEntity> getByLike(BlackListEntity blackListEntity);
    Integer getTotalNumber();

    Integer addBlackList(BlackListEntity blackListEntity);

    Integer updateBlackList(BlackListEntity blackListEntity);

    Integer deleteBlackList(String id_card_number);



}
