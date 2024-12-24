package com.my.springmvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Getter
    @UuidGenerator
    private UUID id;


    @Column(name = "first_name")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String firstName;


    @Column(name = "last_name")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String lastName;


    @Column(name = "nickname")
    private String nickname;


    @Column(name = "email")
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Email(message = "Это не Email")
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;


    @Column(name = "city")
    private String city;
}
