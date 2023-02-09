package com.example.AppointmentSystem.Service;
import com.example.AppointmentSystem.Dao.LogDao;
import com.example.AppointmentSystem.Entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogService {
    @Autowired
    private LogDao logDao;

    public List<LogEntity> queryLimit(Integer currentPage, Integer pageSize){
        return logDao.queryLimit(currentPage, pageSize);
    }

    public List<LogEntity> getByDate(LogEntity logEntity){
        return logDao.getByDate(logEntity);
    }

    public List<LogEntity> getByCreator(LogEntity logEntity){
        return logDao.getByCreator(logEntity);
    }

    public List<LogEntity> getByOperation(LogEntity logEntity){
        return logDao.getByOperation(logEntity);
    }

    public Integer getTotalNumber(){
        return logDao.getTotalNumber();
    }

    public Integer addLog(LogEntity logEntity){
        return logDao.addLog(logEntity);
    }


}
