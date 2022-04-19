package com.edcodehub.edcodehub.repository;

import com.edcodehub.edcodehub.domain.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {

}
