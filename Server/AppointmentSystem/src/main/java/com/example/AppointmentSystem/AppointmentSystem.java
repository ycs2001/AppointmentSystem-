package com.example.AppointmentSystem;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.AppointmentSystem.Dao")
public class AppointmentSystem {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentSystem.class, args);
    }

}
