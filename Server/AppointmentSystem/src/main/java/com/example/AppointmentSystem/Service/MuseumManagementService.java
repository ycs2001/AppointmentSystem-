package com.example.AppointmentSystem.Service;

import com.example.AppointmentSystem.Dao.MuseumManagementDao;
import com.example.AppointmentSystem.Entity.MuseumManagementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumManagementService {
    @Autowired
    private MuseumManagementDao museumManagementDao;


    public List<MuseumManagementEntity> queryLimit(Integer currentPage, Integer pageSize){
        return museumManagementDao.queryLimit(currentPage,pageSize);
    }

    public List<MuseumManagementEntity> queryActivity(Integer currentPage, Integer pageSize){
        return museumManagementDao.queryActivity(currentPage,pageSize);
    }

    public List<MuseumManagementEntity> queryEvent(Integer currentPage, Integer pageSize){
        return museumManagementDao.queryEvent(currentPage,pageSize);
    }

    public List<MuseumManagementEntity> getByLike(MuseumManagementEntity museumManagementEntityEntity){
        return museumManagementDao.getByLike(museumManagementEntityEntity);
    }
    public Integer getTotalNumber(){
        return museumManagementDao.getTotalNumber();
    }

    public Integer addMuseumManagementList(MuseumManagementEntity museumManagementEntityEntity){
        return museumManagementDao.addMuseumManagementList(museumManagementEntityEntity);
    }

    public Integer updateMuseumManagementList(MuseumManagementEntity museumManagementEntityEntity){
        return museumManagementDao.updateMuseumManagementList(museumManagementEntityEntity);
    }

    public Integer deleteMuseumManagementList(String museum_id){
        return museumManagementDao.deleteMuseumManagementList(museum_id);
    }

}
