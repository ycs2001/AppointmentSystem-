package com.example.AppointmentSystem.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

public class VisitEntity {
    private String open_location;
    private Time open_start_time;
    private Time open_end_time;
    private int open_people_number;
    private String open_staff_in_charge;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date open_date;

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public String getOpen_location() {
        return open_location;
    }

    public void setOpen_location(String open_location) {
        this.open_location = open_location;
    }

    public Date getOpen_start_time() {
        return open_start_time;
    }

    public void setOpen_start_time(Time open_start_time) {
        this.open_start_time = open_start_time;
    }

    public Date getOpen_end_time() {
        return open_end_time;
    }

    public void setOpen_end_time(Time open_end_time) {
        this.open_end_time = open_end_time;
    }

    public int getOpen_people_number() {
        return open_people_number;
    }

    public void setOpen_people_number(int open_people_number) {
        this.open_people_number = open_people_number;
    }

    public String getOpen_staff_in_charge() {
        return open_staff_in_charge;
    }

    public void setOpen_staff_in_charge(String open_staff_in_charge) {
        this.open_staff_in_charge = open_staff_in_charge;
    }
}
