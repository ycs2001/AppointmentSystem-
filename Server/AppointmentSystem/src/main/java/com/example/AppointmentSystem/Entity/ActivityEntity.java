package com.example.AppointmentSystem.Entity;

import java.sql.Date;

public class ActivityEntity {
    private String activity_name;
    private Date activity_start_time;
    private Date activity_end_time;
    private String activity_location;
    private int activity_number;
    private String activity_introduction;
    private String activity_details;

    public int getActivity_number() {
        return activity_number;
    }

    public void setActivity_number(int activity_number) {
        this.activity_number = activity_number;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public Date getActivity_start_time() {
        return activity_start_time;
    }

    public void setActivity_start_time(Date activity_start_time) {
        this.activity_start_time = activity_start_time;
    }

    public Date getActivity_end_time() {
        return activity_end_time;
    }

    public void setActivity_end_time(Date activity_end_time) {
        this.activity_end_time = activity_end_time;
    }

    public String getActivity_location() {
        return activity_location;
    }

    public void setActivity_location(String activity_location) {
        this.activity_location = activity_location;
    }

    public String getActivity_introduction() {
        return activity_introduction;
    }

    public void setActivity_introduction(String activity_introduction) {
        this.activity_introduction = activity_introduction;
    }

    public String getActivity_details() {
        return activity_details;
    }

    public void setActivity_details(String activity_details) {
        this.activity_details = activity_details;
    }
}
