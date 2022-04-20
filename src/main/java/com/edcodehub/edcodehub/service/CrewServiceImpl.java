package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.Crew;
import com.edcodehub.edcodehub.domain.Movie;
import com.edcodehub.edcodehub.domain.Person;
import com.edcodehub.edcodehub.domain.TVShow;
import com.edcodehub.edcodehub.enums.Role;
import com.edcodehub.edcodehub.repository.CrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CrewServiceImpl extends BaseServiceImpl<Crew> implements CrewService {
    private final CrewRepository crewRepository;

    @Override
    public JpaRepository<Crew, Long> getRepository() { return crewRepository; }

    @Override
    public void addTVShowCrew(Person person, TVShow tvShow, Role role) {

        person.getCrew().add(newCrew(person, tvShow, role, null));

        logger.debug("Person[{}] added to TVShow[{}]", person, tvShow);
    }

    @Override
    public void addMovieCrew(Person person, Movie movie, Role role) {

        person.getCrew().add(newCrew(person, null, role, movie));

        logger.debug("Person[{}] added to Movie[{}]", person, movie);
    }

    private Crew newCrew(Person person, TVShow tvShow, Role role, Movie movie) {
        return Crew.builder().person(person).tvShow(tvShow).role(role).movie(movie).build();
    }
}
