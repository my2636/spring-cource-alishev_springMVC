package com.my.springmvc.dto;

import com.my.springmvc.model.Vacation;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO {

    private UUID personId;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private LocalDate birthday;
    private String city;

    public PersonDTO(UUID personId, String firstName, String lastName, String nickname, String email, LocalDate birthday, String city, List<Vacation> personVacations) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.email = email;
        this.birthday = birthday;
        this.city = city;
        this.personVacations = personVacations;
    }

    List<Vacation> personVacations;
}
