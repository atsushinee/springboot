package org.ihsusta.spring.controller;

import org.ihsusta.spring.damain.Person;
import org.ihsusta.spring.damain.Result;
import org.ihsusta.spring.respository.PersonRespository;
import org.ihsusta.spring.service.PersonService;
import org.ihsusta.spring.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SpringController {

    private PersonRespository personRespository;
    private PersonService personService;

    @Autowired
    public SpringController(PersonRespository personRespository,
                            PersonService personService) {
        this.personRespository = personRespository;
        this.personService = personService;
    }

    @GetMapping()
    public String home() {
        return "<h1>Welcome to my homepage</h1>";
    }

    @GetMapping(value = "/show/{id}")
    public Person show(@PathVariable("id") Integer id) {

        return personRespository.findOne(id);
    }

    @GetMapping(value = "/show")
    public List<Person> show() {

        return personRespository.findAll();
    }

    @GetMapping(value = "/save")
    public Result save(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        person.setAge(person.getAge());
        person.setName(person.getName());
        return ResultUtil.success(personRespository.save(person));
    }

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        personService.getAge(id);
    }
}
