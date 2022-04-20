package com.edcodehub.edcodehub.domain;

import com.edcodehub.edcodehub.enums.Genre;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class BaseProduct extends BaseModel {
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
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
	
	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
	private Set<Crew> crewSet = new HashSet<>();
}
