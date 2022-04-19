package com.edcodehub.edcodehub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseProduct extends BaseModel {
	
	@Column(length = 30, nullable = false)
	private String genre;
	
	@Column
	private Double rating;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal budget;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Integer duration;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 4096)
	private String storyline;
	
	@OneToMany(mappedBy = "person")
	private Set<Crew> crewSet = new HashSet<>();
}
