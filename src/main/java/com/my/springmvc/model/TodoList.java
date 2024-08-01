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
@Table(name = "todo_list")
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "vacation_id")
    private UUID vacationId;
}
