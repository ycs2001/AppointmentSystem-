package com.example.AppointmentSystem.Entity;
import org.codehaus.jackson.annotate.JsonProperty;

public class BlackListEntity {
    private String black_name;

    private String id_card_number;
    private String phone_number;
    private String default_times;

    private String time_of_default;

    public String getBlack_name() {
        return black_name;
    }

    public void setBlack_name(String black_name) {
        this.black_name = black_name;
    }

    public String getID_card_number() {
        return id_card_number;
    }

    public void setID_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDefault_times() {
        return default_times;
    }

    public void setDefault_times(String default_times) {
        this.default_times = default_times;
    }
    public String getTime_of_default() {
        return time_of_default;
    }

    public void setTime_of_default(String time_of_default) {
        this.time_of_default = time_of_default;
    }
}
