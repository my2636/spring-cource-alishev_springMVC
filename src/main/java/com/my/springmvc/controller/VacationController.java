package com.my.springmvc.controller;

import com.my.springmvc.dao.VacationDAO;
import com.my.springmvc.model.Person;
import com.my.springmvc.model.Vacation;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/vacations")
public class VacationController {
    public VacationController(VacationDAO vacationDAO) {
        this.vacationDAO = vacationDAO;
    }

    private final VacationDAO vacationDAO;



/*    @GetMapping("/{id}")
    public String showVacation(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("vacation", vacationDAO.show(id));
        return "vacations/show";
    }*/



/*    @PostMapping()
    public String create(@ModelAttribute("vacation") @Valid Vacation vacation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "vacations/new";
        }

        vacationDAO.save(vacation);
        UUID id = vacation.getId();
        return "redirect:/vacations/{id}";
    }*/

/*
    @GetMapping("/{userId}")
    public String showVacations(@PathVariable("userId") UUID id, Model model) {
        model.addAttribute("vacation", vacationDAO.show(id));
        return "vacations/show";
    }
*/


}
