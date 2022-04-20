package com.edcodehub.edcodehub.domain;

import com.edcodehub.edcodehub.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private Person person;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	private Movie movie;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	private TVShow tvShow;
}
