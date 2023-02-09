package com.example.AppointmentSystem.Entity;

public class MessageEntity {
    private String activity_name;
    private String appointed_S_message;
    private String appointed_F_message;
    private String changes_activity;

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getAppointed_S_message() {
        return appointed_S_message;
    }

    public void setAppointed_S_message(String appointed_S_message) {
        this.appointed_S_message = appointed_S_message;
    }

    public String getAppointed_F_message() {
        return appointed_F_message;
    }

    public void setAppointed_F_message(String appointed_F_message) {
        this.appointed_F_message = appointed_F_message;
    }

    public String getChanges_activity() {
        return changes_activity;
    }

    public void setChanges_activity(String changes_activity) {
        this.changes_activity = changes_activity;
    }
}
