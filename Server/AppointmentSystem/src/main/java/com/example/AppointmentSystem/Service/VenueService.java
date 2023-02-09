package com.example.AppointmentSystem.Service;


import com.example.AppointmentSystem.Dao.VenueDao;
import com.example.AppointmentSystem.Entity.VenueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    @Autowired
    public VenueDao venueDao;

    public List<VenueEntity> queryLimit(Integer currentPage, Integer pageSize){
       return venueDao.queryLimit(currentPage,pageSize);

    }

    public List<VenueEntity> queryVenue(Integer currentPage, Integer pageSize){
        return venueDao.queryVenue(currentPage,pageSize);

    }

    public Integer upload(VenueEntity venueEntity){
        return venueDao.upload(venueEntity);
    }

    public List<VenueEntity> getByLike(VenueEntity venueEntity){
        return venueDao.getByLike(venueEntity);
    }
    public Integer getTotalNumber(){
        return venueDao.getTotalNumber();
    }



    public Integer addVenue(VenueEntity venueEntity){
        return venueDao.addVenue(venueEntity);
    }

    public Integer updateVenue(VenueEntity venueEntity){
        return venueDao.updateVenue(venueEntity);
    }

    public  Integer deleteVenue(String venue_name){
        return venueDao.deleteVenue(venue_name);
    }






}
