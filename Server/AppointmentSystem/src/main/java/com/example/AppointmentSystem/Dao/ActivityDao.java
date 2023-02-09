package com.example.AppointmentSystem.Dao;

import com.example.AppointmentSystem.Entity.ActivityEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface ActivityDao {

    List<ActivityEntity> queryLimit(Integer currentPage, Integer pageSize);

    List<ActivityEntity> getByLike(ActivityEntity activity);

    Integer getTotalNumber();

    Integer addActivity(ActivityEntity activity);

    Integer updateActivity(ActivityEntity activity);

    Integer deleteActivity(String activity_name);

}
