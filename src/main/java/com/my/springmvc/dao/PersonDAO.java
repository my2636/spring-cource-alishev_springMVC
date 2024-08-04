package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(id, first_name, last_name, nickname, email, birthday, city) VALUES(uuid_generate_v4(), ?, ?, ?, ?, ?, ?)", person.getFirstName(),
                person.getLastName(), person.getNickname(), person.getEmail(), person.getBirthday(), person.getCity());
    }

    public Person show(UUID id) {
        Person person = null;
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void update(UUID id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET first_name=?, last_name=?, nickname=?, email=?, birthday=?, city=? WHERE id=?",
                updatePerson.getFirstName(), updatePerson.getLastName(), updatePerson.getNickname(),
                updatePerson.getEmail(), updatePerson.getBirthday(), updatePerson.getCity(), id);
    }

    public void delete(UUID id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}