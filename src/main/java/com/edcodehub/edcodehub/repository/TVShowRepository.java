package com.edcodehub.edcodehub.repository;

import com.edcodehub.edcodehub.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow, Long> {

}
