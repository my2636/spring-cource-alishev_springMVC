package com.my.springmvc.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class VacationFeatures {
    private int id;

    private int vacationId;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 2, max = 15, message = "до 15 символов")
    private String featureName;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size( max = 255, message = "(до 255 символов)")
    private String description;

    private boolean completed;

    public VacationFeatures(int id, int vacationId, String featureName ,String description, boolean completed) {
        this.id = id;
        this.vacationId = vacationId;
        this.featureName = featureName;
        this.description = description;
        this.completed = completed;
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

    public String featureName() {
        return featureName;
    }

    public void featureName(String description) {
        this.featureName = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
