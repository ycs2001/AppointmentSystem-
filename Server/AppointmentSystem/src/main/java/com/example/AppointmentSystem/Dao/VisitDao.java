package com.example.AppointmentSystem.Dao;
import com.example.AppointmentSystem.Entity.VisitEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface VisitDao {

    List<VisitEntity> queryLimit(Integer currentPage, Integer pageSize);

    List<VisitEntity> getByLike(VisitEntity Visit);

    VisitEntity queryDate(Date date);

    VisitEntity queryNumber(Date date);

    Integer getTotalNumber();

    Integer updateVisit(VisitEntity Visit);

    Integer addVisit(VisitEntity Visit);

    Integer updateVisit_time(VisitEntity Visit);

    Integer updateVisit_location(VisitEntity Visit);

    Integer updateVisit_people_number(VisitEntity Visit);

    Integer updateVisit_staff_in_charge(VisitEntity Visit);

    Integer deleteVisit(Date date);
}
