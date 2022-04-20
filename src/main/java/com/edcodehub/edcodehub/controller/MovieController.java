package com.edcodehub.edcodehub.controller;

import com.edcodehub.edcodehub.domain.Movie;
import com.edcodehub.edcodehub.service.BaseService;
import com.edcodehub.edcodehub.service.MovieService;
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
@RequestMapping("/movie")
public class MovieController extends AbstractController<Movie>{

  private final MovieService movieService;

  @Override
  public BaseService<Movie, Long> getBaseService() {
    return movieService;
  }

  @GetMapping(params = {"title"})
  public ResponseEntity<ApiResponse<Movie>> findByTitle(@RequestParam String title) {
    return new ResponseEntity<>(ApiResponse.<Movie>builder().data(movieService.findByTitle(title)).build(),
        HttpStatus.OK);
  }

}
