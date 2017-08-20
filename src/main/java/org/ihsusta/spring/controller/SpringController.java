package org.ihsusta.spring.controller;

import org.ihsusta.spring.damain.Person;
import org.ihsusta.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringController {

    private PersonService personService;

    @Autowired
    public SpringController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/show/{id}")
    public Person show(@PathVariable("id") Integer id) {

        return personService.findOne(id);
//        return "hello";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public List<Person> show() {

        return personService.findAll();
//        return "hello";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Person save(@RequestParam("name") String name,
                       @RequestParam("age") Integer age) {

        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        return personService.save(person);
//        return "hello";
    }
}
