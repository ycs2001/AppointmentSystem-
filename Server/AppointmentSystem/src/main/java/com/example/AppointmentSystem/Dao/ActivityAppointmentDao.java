package com.example.AppointmentSystem.Dao;

import com.example.AppointmentSystem.Entity.ActivityAppointmentEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;
@Mapper
public interface ActivityAppointmentDao {

    List<ActivityAppointmentEntity> queryLimit(Integer currentPage, Integer pageSize);
    List<ActivityAppointmentEntity> getByLike(ActivityAppointmentEntity ActivityAppointment);
    Integer getTotalNumber();

    Integer addActivityAppointment(ActivityAppointmentEntity ActivityAppointment);

    Integer updateActivityAppointment(ActivityAppointmentEntity ActivityAppointment);

    Integer deleteActivityAppointment(String id_card_number);

}
