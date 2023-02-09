package com.example.AppointmentSystem.Service;
import com.example.AppointmentSystem.Dao.ActivityDao;
import com.example.AppointmentSystem.Entity.ActivityEntity;
import com.example.AppointmentSystem.Entity.BlackListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityDao activityDao;

    public List<ActivityEntity> queryLimit(Integer currentPage, Integer pageSzie){
        return activityDao.queryLimit(currentPage,pageSzie);
    }

    public List<ActivityEntity> getByLike(ActivityEntity activityEntity) { return activityDao.getByLike(activityEntity);}

    public Integer getTotalNumber(){
        return activityDao.getTotalNumber();
    }

    public Integer addActivity(ActivityEntity activity){
        return activityDao.addActivity(activity);
    }

    public Integer updateActivity(ActivityEntity activity){
        return activityDao.updateActivity(activity);
    }

    public Integer deleteActivity(String activity_name){
        return activityDao.deleteActivity(activity_name);
    }

}
