package com.my.springmvc.controller;

import com.my.springmvc.dao.JdbcVacationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/vacations")
public class VacationController {
    private final JdbcVacationDAO jdbcVacationDAO;

    @Autowired
    public VacationController(JdbcVacationDAO jdbcVacationDAO) {
        this.jdbcVacationDAO = jdbcVacationDAO;
    }

    @GetMapping("/{id}")
    public String showVacation(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("vacation", jdbcVacationDAO.show(id));
        return "vacations/show";
    }

/*
    @GetMapping("/{userId}")
    public String showVacations(@PathVariable("userId") UUID id, Model model) {
        model.addAttribute("vacation", vacationDAO.show(id));
        return "vacations/show";
    }
*/


}
