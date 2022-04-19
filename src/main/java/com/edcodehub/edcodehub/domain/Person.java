package com.edcodehub.edcodehub.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
	
	@Column(length = 30, nullable = false)
	private String firstname;
	
	@Column(length = 50, nullable = false)
	private String lastname;
	
	@Column
	private Integer age;
	
	@Column(length = 100, nullable = false)
	private String country;
	
	@OneToMany(mappedBy = "person")
	private Set<Crew> crew;
	
	
}
