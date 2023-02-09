package com.example.AppointmentSystem.Dao;


import com.example.AppointmentSystem.Entity.MuseumManagementEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MuseumManagementDao {
    List<MuseumManagementEntity> queryLimit(Integer currentPage, Integer pageSize);

    List<MuseumManagementEntity> queryActivity(Integer currentPage, Integer pageSize);

    List<MuseumManagementEntity> queryEvent(Integer currentPage, Integer pageSize);

    List<MuseumManagementEntity> getByLike(MuseumManagementEntity museumManagementEntityEntity);
    Integer getTotalNumber();

    Integer addMuseumManagementList(MuseumManagementEntity museumManagementEntityEntity);

    Integer updateMuseumManagementList(MuseumManagementEntity museumManagementEntityEntity);

    Integer deleteMuseumManagementList(String museum_id);


}
