package com.edcodehub.edcodehub.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "MOVIE")
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIE_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends BaseProduct {
	
	@Column
	private Integer sequel;


}
