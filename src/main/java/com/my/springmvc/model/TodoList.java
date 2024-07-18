package com.my.springmvc.model;

public class TodoList {

    private int id;

    private int vacationId;

    private String status;  // -> enum

    public TodoList(int id, int vacationId, String status) {
        this.id = id;
        this.vacationId = vacationId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVacationId() {
        return vacationId;
    }

    public void setVacationId(int vacationId) {
        this.vacationId = vacationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
