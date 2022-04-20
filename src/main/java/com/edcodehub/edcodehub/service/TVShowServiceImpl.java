package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.TVShow;
import com.edcodehub.edcodehub.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService {
    private final TVShowRepository tvshowRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvshowRepository;
    }

    @Override
    public TVShow findByTitle(String title) {
        return tvshowRepository.findByTitle(title);
    }
}
