package com.edcodehub.edcodehub.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TV_SHOW")
@SequenceGenerator(name = "idGenerator", sequenceName = "TV_SHOW_SEQ", initialValue = 1, allocationSize = 1)
public class TVShow extends BaseProduct {
	
	@Column(nullable = false)
	private Integer seasons;
	
	@Column(nullable = false)
	private Integer episodes;
	
}
