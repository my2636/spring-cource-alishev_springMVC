package com.my.springmvc.dto;

import com.my.springmvc.model.Vacation;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    int personId;
    String personFullName;
    String personNickname;
    List<Vacation> personVacations;
}
