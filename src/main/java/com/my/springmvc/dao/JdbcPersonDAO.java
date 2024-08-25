/*
package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JdbcPersonDAO implements PersonDAO{

    private final JdbcTemplate jdbcTemplate;

//    @Autowired
    public JdbcPersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(id, first_name, last_name, nickname, email, birthday, city) VALUES(uuid_generate_v4(), ?, ?, ?, ?, ?, ?)", person.getFirstName(),
                person.getLastName(), person.getNickname(), person.getEmail(), person.getBirthday(), person.getCity());
    }

    @Override
    public Person show(UUID id) {
        Person person = null;
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    @Override
    public void update(UUID id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET first_name=?, last_name=?, nickname=?, email=?, birthday=?, city=? WHERE id=?",
                updatePerson.getFirstName(), updatePerson.getLastName(), updatePerson.getNickname(),
                updatePerson.getEmail(), updatePerson.getBirthday(), updatePerson.getCity(), id);
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}*/
