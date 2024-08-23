package com.my.springmvc.dao;

import com.my.springmvc.model.Vacation;

import java.util.List;
import java.util.UUID;

public interface VacationDAO {

    List<Vacation> index(UUID personId);
    Vacation show(UUID vacationId);
    void save(Vacation vacation);
    void update(UUID id, Vacation updatedVacation);
    void delete(UUID id);
}
