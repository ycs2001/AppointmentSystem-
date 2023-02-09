package com.example.AppointmentSystem.Service;
import com.example.AppointmentSystem.Dao.VisitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AppointmentSystem.Entity.VisitEntity;

import java.util.Date;
import java.util.List;


@Service
public class VisitService {
    @Autowired
    private VisitDao visitDao;

    public Integer getTotalNumber(){
            return visitDao.getTotalNumber();
    }

    public List<VisitEntity> queryLimit(Integer currentPage, Integer pageSize){
        return visitDao.queryLimit(currentPage,pageSize);
    }
    public VisitEntity queryDate(Date date){
        return visitDao.queryDate(date);
    }
    public VisitEntity queryNumber(Date date){
        return visitDao.queryNumber(date);
    }

    public List<VisitEntity> getByLike(VisitEntity Visit){
        return visitDao.getByLike(Visit);
    }

    public Integer addVisit(VisitEntity Visit){
        return visitDao.addVisit(Visit);
    }

    public Integer updateVisit(VisitEntity Visit){
        return visitDao.updateVisit(Visit);
    }


    public Integer updateVisit_time(VisitEntity Visit){
        return visitDao.updateVisit_time(Visit);
    }

    public Integer updateVisit_location(VisitEntity Visit){
        return visitDao.updateVisit_location(Visit);
    }

    public Integer updateVisit_people_number(VisitEntity Visit){
        return visitDao.updateVisit_people_number(Visit);
    }

    public Integer updateVisit_staff_in_charge(VisitEntity Visit){
        return visitDao.updateVisit_staff_in_charge(Visit);
    }

    public Integer deleteVisit(Date date){
        return visitDao.deleteVisit(date);
    }

}
