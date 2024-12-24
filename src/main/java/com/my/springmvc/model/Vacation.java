package com.my.springmvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "vacation")
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "person_id")
    private UUID personId;

    @Column(name = "vacation_name")
    @NotNull(message = "Поле обязательно для заполнения")
    private String vacationName;

    @Column(name = "date_start")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Поле обязательно для заполнения")
    private LocalDate dateStart;

    @Column(name = "date_finish")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Поле обязательно для заполнения")
    private LocalDate dateFinish;

    @Column(name = "is_planned")
    private boolean isPlanned;
}
