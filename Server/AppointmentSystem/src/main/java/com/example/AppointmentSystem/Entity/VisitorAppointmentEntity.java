package com.example.AppointmentSystem.Entity;
import java.sql.Time;
import java.util.Date;



public class VisitorAppointmentEntity {
    private String visitor_name;
    private String id_card_number;
    private String phone_number;
    private Time visitor_start_time;
    private Time visitor_end_time;
    private String venue_booked;
    private String activity_booked;

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Time getVisitor_start_time() {
        return visitor_start_time;
    }

    public void setVisitor_start_time(Time visitor_start_time) {
        this.visitor_start_time = visitor_start_time;
    }

    public Time getVisitor_end_time() {
        return visitor_end_time;
    }

    public void setVisitor_end_time(Time visitor_end_time) {
        this.visitor_end_time = visitor_end_time;
    }

    public String getVenue_booked() {
        return venue_booked;
    }

    public void setVenue_booked(String venue_booked) {
        this.venue_booked = venue_booked;
    }

    public String getActivity_booked() {
        return activity_booked;
    }

    public void setActivity_booked(String activity_booked) {
        this.activity_booked = activity_booked;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    private Date visit_date;




}
