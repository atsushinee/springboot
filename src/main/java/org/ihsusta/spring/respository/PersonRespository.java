package org.ihsusta.spring.respository;

import org.ihsusta.spring.damain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person, Integer> {
}
