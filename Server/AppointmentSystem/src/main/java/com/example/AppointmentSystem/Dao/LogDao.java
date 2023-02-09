package com.example.AppointmentSystem.Dao;

import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogDao {

    List<LogEntity> queryLimit(Integer currentPage, Integer pageSize);

    List<LogEntity> getByDate(LogEntity logEntity);

    List<LogEntity> getByCreator(LogEntity logEntity);

    List<LogEntity> getByOperation(LogEntity logEntity);

    Integer getTotalNumber();

    Integer addLog(LogEntity logEntity);




}
