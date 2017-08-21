package org.ihsusta.spring.service;

import org.ihsusta.spring.damain.Person;
import org.ihsusta.spring.enums.ResultEnum;
import org.ihsusta.spring.exception.PersonException;
import org.ihsusta.spring.respository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRespository personRespository;

    @Autowired
    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public void getAge(Integer id) throws Exception {
        Person person = personRespository.findOne(id);
        Integer age = person.getAge();
        if (age < 10) {
            throw new PersonException(ResultEnum.WZRY);
        } else if (age > 10 && age < 16) {
            throw new PersonException(ResultEnum.LOL);
        }
    }
}
