package com.example.AppointmentSystem.Dao;

import com.example.AppointmentSystem.Entity.BlackListEntity;
import com.example.AppointmentSystem.Entity.VenueEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VenueDao {

    List<VenueEntity> queryLimit(Integer currentPage, Integer pageSize);

    List<VenueEntity> queryVenue(Integer currentPage, Integer pageSize);

    List<VenueEntity> getByLike(VenueEntity venueEntity);
    Integer getTotalNumber();

    Integer upload(VenueEntity venueEntity);
    Integer addVenue(VenueEntity venueEntity);

    Integer updateVenue(VenueEntity venueEntity);

    Integer deleteVenue(String venue_name);
}
