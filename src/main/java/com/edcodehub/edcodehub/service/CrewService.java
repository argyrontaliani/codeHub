package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.Crew;
import com.edcodehub.edcodehub.domain.Movie;
import com.edcodehub.edcodehub.domain.Person;
import com.edcodehub.edcodehub.domain.TVShow;
import com.edcodehub.edcodehub.enums.Role;

public interface CrewService extends BaseService<Crew, Long>{

  void addTVShowCrew(Person person, TVShow tvShow, Role role);

  void addMovieCrew(Person person, Movie movie, Role role);
}
