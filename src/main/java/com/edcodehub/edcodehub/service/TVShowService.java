package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.TVShow;

public interface TVShowService extends BaseService<TVShow, Long>{

  TVShow findByTitle(String title);
}
