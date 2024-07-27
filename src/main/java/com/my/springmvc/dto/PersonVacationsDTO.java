package com.my.springmvc.dto;

import com.my.springmvc.model.Vacation;

import java.util.List;

public class PersonVacationsDTO {
    int personId;
    String personFullName;
    String personNickname;
    List<Vacation> personVacations;
}
