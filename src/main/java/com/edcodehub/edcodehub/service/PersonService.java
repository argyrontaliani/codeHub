package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.Person;

public interface PersonService extends BaseService<Person, Long>{

  Person findByFirstnameAndLastname(String firstName, String lastName);
}
