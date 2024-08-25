package com.my.springmvc.controller;

import com.my.springmvc.dao.*;
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

    private final JpaPersonDAO jpaPersonDAO;
    private final JpaVacationDAO jpaVacationDAO;

    @Autowired
    public PersonController(JpaPersonDAO jpaPersonDAO, JpaVacationDAO jpaVacationDAO) {
        this.jpaPersonDAO = jpaPersonDAO;
        this.jpaVacationDAO = jpaVacationDAO;
    }

    // person
    @GetMapping
    public String index(Model model) {
        model.addAttribute("persons", jpaPersonDAO.index());
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

        jpaPersonDAO.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("person", jpaPersonDAO.show(id));
        model.addAttribute("vacations", jpaVacationDAO.index(id));
        return "persons/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("person", jpaPersonDAO.show(id));
        return "persons/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") UUID id) {
        if(bindingResult.hasErrors()) {
            return "persons/edit";
        }

        jpaPersonDAO.update(id, person);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID id) {
        jpaPersonDAO.delete(id);
        jpaVacationDAO.deletePersonVacations(id);
        return "redirect:/persons";
    }

    // person vacations


}
