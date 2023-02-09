package com.example.AppointmentSystem.Entity;



public class ActivityAppointmentEntity {

    private String visitor_name;
    private String id_card_number;
    private String phone_number;
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

    public String getActivity_booked() {
        return activity_booked;
    }

    public void setActivity_booked(String activity_booked) {
        this.activity_booked = activity_booked;
    }
}
