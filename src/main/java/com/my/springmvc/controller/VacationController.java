package com.my.springmvc.controller;

import com.my.springmvc.dao.VacationDAO;
import com.my.springmvc.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacations")
public class VacationController {
    private final VacationDAO vacationDAO;

    @Autowired
    public VacationController(VacationDAO vacationDAO) {
        this.vacationDAO = vacationDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("vacations", vacationDAO.index());
        return "vacations/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("vacation'/'") Person person) {
        return "vacation/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("vacation") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "vacations/new";
        }

        vacationDAO.save(person);
        return "redirect:/vacations";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("vacation", vacationDAO.show(id));
        return "vacations/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("vacation", vacationDAO.show(id));
        return "vacations/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("vacation") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) {
            return "vacations/edit";
        }

        vacationDAO.update(id, person);
        return "redirect:/vacations";
    }

    @DeleteMapping("/id")
    public String delete(@PathVariable("id") int id) {
        vacationDAO.delete(id);
        return "redirect:/vacations";
    }
}
