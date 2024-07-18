package com.my.springmvc.model;

import jakarta.validation.constraints.NotEmpty;

public class Vacation {

    private int id;

    private int userId;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String vacationName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String vacationDate;

    private boolean isPlanned;

    public Vacation(int id, int userId, String vacationName, String vacationDate, boolean isPlanned) {
        this.id = id;
        this.userId = userId;
        this.vacationName = vacationName;
        this.vacationDate = vacationDate;
        this.isPlanned = isPlanned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVacationName() {
        return vacationName;
    }

    public void setVacationName(String vacationName) {
        this.vacationName = vacationName;
    }

    public String getVacationDate() {
        return vacationDate;
    }

    public void setVacationDate(String vacationDate) {
        this.vacationDate = vacationDate;
    }

    public boolean isPlanned() {
        return isPlanned;
    }

    public void setPlanned(boolean planned) {
        isPlanned = planned;
    }
}
