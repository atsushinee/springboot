package org.ihsusta.spring.controller;

import org.ihsusta.spring.damain.Person;
import org.ihsusta.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SpringController {

    private PersonService personService;

    @Autowired
    public SpringController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String home() {
        return "<h1>Welcome to my homepage</h1>";
    }
    @GetMapping(value = "/show/{id}")
    public Person show(@PathVariable("id") Integer id) {

        return personService.findOne(id);
    }

    @GetMapping(value = "/show")
    public List<Person> show() {

        return personService.findAll();
    }

    @GetMapping(value = "/save")
    public Person save(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        person.setAge(person.getAge());
        person.setName(person.getName());
        return personService.save(person);
    }
}
