package com.edcodehub.edcodehub.controller;

import com.edcodehub.edcodehub.domain.Person;
import com.edcodehub.edcodehub.service.BaseService;
import com.edcodehub.edcodehub.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController extends AbstractController<Person>{

  private final PersonService personService;

  @Override
  public BaseService<Person, Long> getBaseService() {
    return personService;
  }

}