package com.my.springmvc.dao;

import com.my.springmvc.model.Vacation;

import java.util.List;
import java.util.UUID;

public interface VacationDAO {

    List<Vacation> index(UUID personId);
    Vacation show(UUID vacationId);
    void save(Vacation vacation);
    void update(Vacation updatedVacation);
    void delete(UUID id);
    void deletePersonVacations(UUID personId);
}
