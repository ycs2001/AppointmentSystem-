package com.example.AppointmentSystem.Entity;

public class UserEntity {
    private String admin_id;
    private String admin_password;
    private String admin_user_name;
    private String admin_phone_number;
    private String admin_email;

    public String getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_user_name() {
        return admin_user_name;
    }

    public void setAdmin_user_name(String admin_user_name) {
        this.admin_user_name = admin_user_name;
    }

    public String getAdmin_phone_number() {
        return admin_phone_number;
    }

    public void setAdmin_phone_number(String admin_phone_number) {
        this.admin_phone_number = admin_phone_number;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
}
