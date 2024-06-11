package com.example.ProjectBoot.controllers;

import com.example.ProjectBoot.models.Person;
import com.example.ProjectBoot.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonService personService;
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", personService.index());
        return "index";
    }
    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", personService.show(id));
        return "show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        personService.save(person);
        return "redirect:/people";
    }
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("person", personService.show(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @RequestParam("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";

        personService.update(id, person);
        return "redirect:/people";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        personService.deleteUser(id);
        return "redirect:/people";
    }
}
