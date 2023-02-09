package com.example.AppointmentSystem.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AppointmentSystem.Dao.VisitorAppointmentDao;
import com.example.AppointmentSystem.Entity.VisitorAppointmentEntity;

import java.sql.Date;
import java.util.List;


@Service
public class VisitorAppointmentService {
    @Autowired
    private VisitorAppointmentDao visitorAppointmentDao;


    public List<VisitorAppointmentEntity> queryLimit(Integer currentPage, Integer pageSize){
        return visitorAppointmentDao.queryLimit(currentPage,pageSize);
    }

    public List<VisitorAppointmentEntity> getByLike(VisitorAppointmentEntity VisitorAppointment) { return visitorAppointmentDao.getByLike(VisitorAppointment);}

    public Integer getTotalNumber(){
        return visitorAppointmentDao.getTotalNumber();
    }

    public Integer addVisitorAppointment(VisitorAppointmentEntity VisitorAppointment){
        return visitorAppointmentDao.addVisitorAppointment(VisitorAppointment);
    }

    public Integer updateVisitorAppointment(VisitorAppointmentEntity VisitorAppointment){
        return visitorAppointmentDao.updateVisitorAppointment(VisitorAppointment);
    }

    public Integer deleteVisitorAppointment(String id_card_number, Date visit_date){
        return visitorAppointmentDao.deleteVisitorAppointment(id_card_number,visit_date);
    }

}
