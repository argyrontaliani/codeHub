package com.edcodehub.edcodehub.controller;

import com.edcodehub.edcodehub.domain.Person;
import com.edcodehub.edcodehub.service.BaseService;
import com.edcodehub.edcodehub.service.PersonService;
import com.edcodehub.edcodehub.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping(params = {"firstname", "lastname"})
  public ResponseEntity<ApiResponse<Person>> findByEmail(@RequestParam String firstname, @RequestParam String lastname) {
    return new ResponseEntity<>(ApiResponse.<Person>builder().data(personService.findByFirstnameAndLastname(firstname, lastname)).build(),
        HttpStatus.OK);
  }

}