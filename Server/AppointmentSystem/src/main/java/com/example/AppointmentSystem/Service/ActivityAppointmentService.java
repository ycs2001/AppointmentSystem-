package com.example.AppointmentSystem.Service;

import com.example.AppointmentSystem.Dao.ActivityAppointmentDao;
import com.example.AppointmentSystem.Dao.VisitorAppointmentDao;
import com.example.AppointmentSystem.Entity.ActivityAppointmentEntity;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ActivityAppointmentService {
    @Autowired
    private ActivityAppointmentDao activityAppointmentDao;


    public List<ActivityAppointmentEntity> queryLimit(Integer currentPage, Integer pageSize){
        return activityAppointmentDao.queryLimit(currentPage,pageSize);
    }

    public List<ActivityAppointmentEntity> getByLike(ActivityAppointmentEntity activityAppointment) { return activityAppointmentDao.getByLike(activityAppointment);}

    public Integer getTotalNumber(){
        return activityAppointmentDao.getTotalNumber();
    }

    public Integer addActivityAppointment(ActivityAppointmentEntity ActivityAppointment){
        return activityAppointmentDao.addActivityAppointment(ActivityAppointment);
    }

    public Integer updateActivityAppointment(ActivityAppointmentEntity ActivityAppointment){
        return activityAppointmentDao.updateActivityAppointment(ActivityAppointment);
    }

    public Integer deleteActivityAppointment(String visitor_name){
        return activityAppointmentDao.deleteActivityAppointment(visitor_name);
    }
}
