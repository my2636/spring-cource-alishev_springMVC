package com.my.springmvc.model;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class Vacation {

    private int id;

    private int personId;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private String vacationName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private LocalDate dateStart;

    @NotEmpty(message = "Поле обязательно для заполнения")
    private LocalDate dateFinish;

    private boolean isPlanned;

    public Vacation() {}

    public Vacation(int id, int personId, String vacationName, LocalDate dateStart, LocalDate dateFinish, boolean isPlanned) {
        this.id = id;
        this.personId = personId;
        this.vacationName = vacationName;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.isPlanned = isPlanned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getVacationName() {
        return vacationName;
    }

    public void setVacationName(String vacationName) {
        this.vacationName = vacationName;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate vacationDate) {
        this.dateStart = vacationDate;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public boolean isPlanned() {
        return isPlanned;
    }

    public void setPlanned(boolean planned) {
        isPlanned = planned;
    }
}
