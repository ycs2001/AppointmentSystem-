package com.example.AppointmentSystem.Entity;

public class MuseumManagementEntity {

    private String museum_introduction;
    private String EventList_title;
    private String EventList_content;
    private String activityList_title;
    private String activityList_content;
    private String museum_id;

    public String getMuseum_introduction() {
        return museum_introduction;
    }

    public void setMuseum_introduction(String museum_introduction) {
        this.museum_introduction = museum_introduction;
    }

    public String getEventList_title() {
        return EventList_title;
    }

    public void setEventList_title(String eventList_title) {
        this.EventList_title = eventList_title;
    }

    public String getEventList_content() {
        return EventList_content;
    }

    public void setEventList_content(String eventList_content) {
        EventList_content = eventList_content;
    }

    public String getActivityList_title() {
        return activityList_title;
    }

    public void setActivityList_title(String activityList_title) {
        this.activityList_title = activityList_title;
    }

    public String getActivityList_content() {
        return activityList_content;
    }

    public void setActivityList_content(String activityList_content) {
        this.activityList_content = activityList_content;
    }

    public String getMuseum_id() {
        return museum_id;
    }

    public void setMuseum_id(String museum_id) {
        this.museum_id = museum_id;
    }
}
