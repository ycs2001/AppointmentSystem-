package com.example.AppointmentSystem.Service;
import com.example.AppointmentSystem.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.AppointmentSystem.Entity.UserEntity;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public List<UserEntity> queryLimit(Integer currentPage, Integer pageSzie){
        return userDao.queryLimit(currentPage,pageSzie);
    }



    public Integer addUser(UserEntity user){
        return userDao.addUser(user);
    }

    public Integer updateUser(UserEntity user){
        return userDao.updateUser(user);
    }

    public Integer deleteUser(UserEntity user){
        return userDao.deleteUser(user);
    }

    public String login(UserEntity user) {
        return userDao.login(user);
    }


}
