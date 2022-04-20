package com.edcodehub.edcodehub.bootstrap;

import com.edcodehub.edcodehub.base.BaseComponent;
import com.edcodehub.edcodehub.domain.Movie;
import com.edcodehub.edcodehub.domain.Person;
import com.edcodehub.edcodehub.domain.TVShow;
import com.edcodehub.edcodehub.enums.Genre;
import com.edcodehub.edcodehub.enums.Role;
import com.edcodehub.edcodehub.service.CrewService;
import com.edcodehub.edcodehub.service.MovieService;
import com.edcodehub.edcodehub.service.PersonService;
import com.edcodehub.edcodehub.service.TVShowService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("generate-basic-content")
@RequiredArgsConstructor
public class BasicSampleContentCreator extends BaseComponent implements CommandLineRunner {

  private final MovieService movieService;
  private final PersonService personService;
  private final CrewService crewService;
  private final TVShowService tvShowService;

  private static final String GREECE = "Greece";

  @Override
  public void run(String... args) {
    List<Movie> movies = List.of(Movie.builder().sequel(1).genre(Genre.ADVENTURE).
            budget(BigDecimal.valueOf(1000000)).duration(120).title("Harry Potter").year(2000).build(),
        Movie.builder().sequel(1).genre(Genre.HORROR).
            budget(BigDecimal.valueOf(20000)).duration(110).title("The nun").year(2020).build(),
        Movie.builder().sequel(0).genre(Genre.COMEDY).
            budget(BigDecimal.valueOf(12000)).duration(120).title("The mask").year(1990).build());

    logger.info("Created {} movies.", movieService.createAll(movies).size());

    List<TVShow> tvShows = List.of(TVShow.builder().genre(Genre.ADVENTURE).
            budget(BigDecimal.valueOf(1000000)).duration(120).title("Flash").year(2000).episodes(12)
            .seasons(5).build(),
        TVShow.builder().genre(Genre.HORROR).
            budget(BigDecimal.valueOf(20000)).duration(110).title("Horror stories").year(2020)
            .episodes(8).seasons(3).build(),
        TVShow.builder().genre(Genre.COMEDY).
            budget(BigDecimal.valueOf(12000)).duration(120).title("Friends").year(1990).episodes(12)
            .seasons(10).build());

    logger.info("Created {} tv Shows.", tvShowService.createAll(tvShows).size());

    List<Person> persons = personService.createAll(
        Person.builder()
            .firstname("Konna").lastname("B").country(GREECE).age(47).build(),
        Person.builder()
            .firstname("Argy").lastname("Nt").country(GREECE).age(40).build(),
        Person.builder().country(GREECE)
            .firstname("Teo").lastname("Chas").age(32).build(),
        Person.builder().country(GREECE)
            .firstname("Pan").lastname("Stath").age(57).build(),
        Person.builder().country(GREECE)
            .firstname("Miltos").lastname("Dami").age(32).build());
    logger.info("Persons created: {}.", persons);

    Person person1 = personService.findByFirstnameAndLastname("Konna", "B");
    Movie movie1 = movieService.findByTitle("Harry Potter");
    crewService.addMovieCrew(person1, movie1, Role.ACTOR);
    crewService.addMovieCrew(person1, movie1, Role.DIRECTOR);

    Person person2 = personService.findByFirstnameAndLastname("Argy", "Nt");
    Movie movie2 = movieService.findByTitle("The nun");
    TVShow tvShow = tvShowService.findByTitle("Horror stories");
    crewService.addMovieCrew(person2, movie2, Role.DIRECTOR);
    crewService.addTVShowCrew(person2, tvShow, Role.DIRECTOR);

  }
}
