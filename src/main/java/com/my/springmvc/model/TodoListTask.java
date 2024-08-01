package com.my.springmvc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "todo_list_task")
@NoArgsConstructor
@AllArgsConstructor
public class TodoListTask {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "todo_list_id")
    private UUID todoListId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private boolean completed;
}