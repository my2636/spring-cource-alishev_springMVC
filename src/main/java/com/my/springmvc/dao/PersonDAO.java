package com.my.springmvc.dao;

import com.my.springmvc.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDAO {
    List<Person> index();
    Person show(UUID id);
    void save(Person person);
    void update(Person updatePerson);
    void delete(UUID id);
}
