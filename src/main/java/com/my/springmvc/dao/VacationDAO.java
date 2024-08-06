package com.my.springmvc.dao;

import com.my.springmvc.model.Vacation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.stream;

@Component
public class VacationDAO {
    private final JdbcTemplate jdbcTemplate;

    public VacationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vacation> index(UUID personId) {
        return jdbcTemplate.query("SELECT * FROM Vacation WHERE person_id=?", new Object[]{personId}, new BeanPropertyRowMapper<>(Vacation.class));
    }
    public Vacation show(UUID vacationId) {
        return jdbcTemplate.query("SELECT * FROM Vacation WHERE id=?", new Object[]{vacationId}, new BeanPropertyRowMapper<>(Vacation.class))
                .stream().findAny().orElse(null);
    }

    public void delete(UUID personId) {
        jdbcTemplate.update("DELETE FROM Vacation WHERE person_id=?", personId);
    }
}
