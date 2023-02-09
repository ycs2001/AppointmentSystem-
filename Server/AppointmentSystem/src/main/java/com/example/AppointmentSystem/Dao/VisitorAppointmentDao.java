package com.example.AppointmentSystem.Dao;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface VisitorAppointmentDao {

    List<VisitorAppointmentEntity> queryLimit(Integer currentPage, Integer pageSize);
    List<VisitorAppointmentEntity> getByLike(VisitorAppointmentEntity VisitorAppointment);
    Integer getTotalNumber();

    Integer addVisitorAppointment(VisitorAppointmentEntity VisitorAppointment);

    Integer updateVisitorAppointment(VisitorAppointmentEntity VisitorAppointment);

    Integer deleteVisitorAppointment(String id_card_number, Date visit_date);



}
