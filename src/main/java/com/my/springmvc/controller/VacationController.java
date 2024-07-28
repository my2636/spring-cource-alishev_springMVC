package com.my.springmvc.controller;

import com.my.springmvc.dao.VacationDAO;
import com.my.springmvc.model.Person;
import com.my.springmvc.model.Vacation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacations")
public class VacationController {
/*    private final VacationDAO vacationDAO;

    @Autowired
    public VacationController(VacationDAO vacationDAO) {
        this.vacationDAO = vacationDAO;
    }

    @PostMapping()
    public String create(@ModelAttribute("vacation") @Valid Vacation vacation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "persons/new";
        }

        personDAO.save(person);
        return "redirect:/persons";
    }*/

}
