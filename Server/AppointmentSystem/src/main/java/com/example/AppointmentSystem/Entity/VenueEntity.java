package com.example.AppointmentSystem.Entity;

import org.springframework.web.multipart.MultipartFile;

public class VenueEntity {
    private String venue_name;
    private String venue_introduction;
    private Integer venue_number;
    private byte[] venue_picture;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private MultipartFile file;

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getVenue_introduction() {
        return venue_introduction;
    }

    public void setVenue_introduction(String venue_introduction) {
        this.venue_introduction = venue_introduction;
    }

    public Integer getVenue_number() {
        return venue_number;
    }

    public void setVenue_number(Integer venue_number) {
        this.venue_number = venue_number;
    }

    public byte[] getVenue_picture() {
        return venue_picture;
    }

    public void setVenue_picture(byte[] venue_picture) {
        this.venue_picture = venue_picture;
    }
}
