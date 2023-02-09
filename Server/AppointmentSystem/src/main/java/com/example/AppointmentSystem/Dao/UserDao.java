package com.example.AppointmentSystem.Dao;
import com.example.AppointmentSystem.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    List<UserEntity> queryLimit(Integer currentPage, Integer pageSize);

    Integer addUser(UserEntity user);

    Integer updateUser(UserEntity user);

    Integer deleteUser(UserEntity user);

    String login(UserEntity user);

}
