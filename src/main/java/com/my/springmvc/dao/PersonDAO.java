package com.my.springmvc.dao;

import com.my.springmvc.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDAO {
    List<Person> index();
    void save(Person person);
    Person show(UUID id);
    void update(UUID id, Person updatePerson);
    void delete(UUID id);
}
