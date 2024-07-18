package com.my.springmvc.model;

public class TodoListTask {

    int id;

    private int todoListId;

    private String taskName;

    private String description;

    private boolean completed;


    public TodoListTask(int todoListId, String taskName, String description, boolean completed) {
        this.id = id;
        this.todoListId = todoListId;
        this.taskName = taskName;
        this.description = description;
        this.completed = completed;
    }

    public boolean getIsCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(int todoListId) {
        this.todoListId = todoListId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}