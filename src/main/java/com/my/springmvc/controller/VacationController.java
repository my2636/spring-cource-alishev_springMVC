package com.my.springmvc.controller;

import com.my.springmvc.dao.VacationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/vacations")
public class VacationController {
    private final VacationDAO vacationDAO;

    @Autowired
    public VacationController(VacationDAO vacationDAO) {
        this.vacationDAO = vacationDAO;
    }

    @GetMapping("/{id}")
    public String showVacation(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("vacation", vacationDAO.show(id));
        return "vacations/show";
    }

}
