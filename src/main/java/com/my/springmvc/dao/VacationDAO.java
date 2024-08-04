package com.my.springmvc.dao;

import com.my.springmvc.model.Vacation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class VacationDAO {
    private final JdbcTemplate jdbcTemplate;

    public VacationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vacation> index(UUID personId) {
        return jdbcTemplate.query("SELECT * FROM Vacation WHERE person_id=?", new Object[]{personId}, new BeanPropertyRowMapper<>(Vacation.class));
    }

    public void delete(UUID personId) {
        jdbcTemplate.update("DELETE FROM Vacation WHERE person_id=?", personId);
    }
}
