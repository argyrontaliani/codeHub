package com.edcodehub.edcodehub.service;

import com.edcodehub.edcodehub.domain.Crew;
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
}
