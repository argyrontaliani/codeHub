package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.Person;
import com.edcodehub.edcodehub.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() { return personRepository; }

    @Override
    public Person findByFirstnameAndLastname(String firstName, String lastName) {
        return personRepository.findByFirstnameAndLastname(firstName, lastName);
    }
}
