package com.edcodehub.edcodehub.repository;

import com.edcodehub.edcodehub.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  
  Person findByFirstnameAndLastname(String firstName, String lastName);

}
