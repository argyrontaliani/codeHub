package com.edcodehub.edcodehub.controller;

import com.edcodehub.edcodehub.domain.TVShow;
import com.edcodehub.edcodehub.service.BaseService;
import com.edcodehub.edcodehub.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tv-show")
public class TVShowController extends AbstractController<TVShow>{

  private final TVShowService tvShowService;

  @Override
  public BaseService<TVShow, Long> getBaseService() {
    return tvShowService;
  }

}
