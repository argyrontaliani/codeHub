package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.Movie;

public interface MovieService extends BaseService<Movie, Long>{

  Movie findByTitle(String title);
}
