package com.my.springmvc.dao;

import com.my.springmvc.model.Person;
import com.my.springmvc.model.Vacation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacationDAO {
    private final JdbcTemplate jdbcTemplate;

    public VacationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vacation> index(int personId) {
        return jdbcTemplate.query("SELECT * FROM Vacations WHERE user_id=?", new Object[]{personId}, new BeanPropertyRowMapper<>(Vacation.class));
    }
}
