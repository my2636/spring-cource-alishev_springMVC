package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
        jdbcTemplate.update("INSERT INTO Person(first_name, last_name, nickname, email, birthday, city) VALUES(?, ?, ?, ?, ?, ?)", person.getFirstName(),
                person.getLastName(), person.getNickname(), person.getEmail(), person.getBirthday(), person.getCity());
    }

    public Person show(int id) {
        Person person;
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }
}
