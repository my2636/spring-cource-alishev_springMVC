package com.my.springmvc.controller;

import com.my.springmvc.dao.PersonDAO;
import com.my.springmvc.dao.VacationDAO;
import com.my.springmvc.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonDAO personDAO;
    private final VacationDAO vacationDAO;

    @Autowired
    public PersonController(PersonDAO personDAO, VacationDAO vacationDAO) {
        this.personDAO = personDAO;
        this.vacationDAO = vacationDAO;
    }

    // person
    @GetMapping
    public String index(Model model) {
        model.addAttribute("persons", personDAO.index());
        return "persons/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "persons/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "persons/new";
        }

        personDAO.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("vacations", vacationDAO.index(id));
        return "persons/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("person", personDAO.show(id));
        return "persons/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") UUID id) {
        if(bindingResult.hasErrors()) {
            return "persons/edit";
        }

        personDAO.update(id, person);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID id) {
        personDAO.delete(id);
        vacationDAO.delete(id);
        return "redirect:/persons";
    }

    // person vacations


}
