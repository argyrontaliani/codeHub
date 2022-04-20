package com.edcodehub.edcodehub.controller;

import com.edcodehub.edcodehub.domain.Movie;
import com.edcodehub.edcodehub.service.BaseService;
import com.edcodehub.edcodehub.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController extends AbstractController<Movie>{

  private final MovieService movieService;

  @Override
  public BaseService<Movie, Long> getBaseService() {
    return movieService;
  }

}
