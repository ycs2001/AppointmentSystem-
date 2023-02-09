package com.example.AppointmentSystem.Entity;

import java.sql.Date;

public class LogEntity {
    private String operation;
    private String creator;

    public LogEntity(String operation, String creator, Date operation_time) {
        this.operation = operation;
        this.creator = creator;
        this.operation_time = operation_time;
    }

    private Date operation_time;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
    }
}
