package com.my.springmvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "vacation_features")
@NoArgsConstructor
@AllArgsConstructor
public class VacationFeatures {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @Column(name = "vacation_id")
    private UUID vacationId;

    @Column(name = "feature_name")
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size(min = 2, max = 15, message = "до 15 символов")
    private String featureName;

    @Column(name = "description")
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Size( max = 255, message = "(до 255 символов)")
    private String description;

    @Column(name = "completed")
    private boolean completed;
}
