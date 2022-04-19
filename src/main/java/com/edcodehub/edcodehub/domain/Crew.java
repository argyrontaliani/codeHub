package com.edcodehub.edcodehub.domain;

import com.edcodehub.edcodehub.enums.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "CREW")
@SequenceGenerator(name = "idGenerator", sequenceName = "CREW_SEQ", initialValue = 1, allocationSize = 1)
public class Crew extends BaseModel {
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Person person;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TVShow tvShow;
}
