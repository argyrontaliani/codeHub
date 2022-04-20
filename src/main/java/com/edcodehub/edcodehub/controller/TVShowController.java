package com.edcodehub.edcodehub.controller;

import com.edcodehub.edcodehub.domain.TVShow;
import com.edcodehub.edcodehub.service.BaseService;
import com.edcodehub.edcodehub.service.TVShowService;
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
@RequestMapping("/tv-show")
public class TVShowController extends AbstractController<TVShow>{

  private final TVShowService tvShowService;

  @Override
  public BaseService<TVShow, Long> getBaseService() {
    return tvShowService;
  }

  @GetMapping(params = {"title"})
  public ResponseEntity<ApiResponse<TVShow>> findByTitle(@RequestParam String title) {
    return new ResponseEntity<>(ApiResponse.<TVShow>builder().data(tvShowService.findByTitle(title)).build(),
        HttpStatus.OK);
  }

}
