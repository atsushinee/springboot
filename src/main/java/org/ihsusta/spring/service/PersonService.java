package org.ihsusta.spring.service;

import org.ihsusta.spring.damain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonService extends JpaRepository<Person, Integer> {

}
