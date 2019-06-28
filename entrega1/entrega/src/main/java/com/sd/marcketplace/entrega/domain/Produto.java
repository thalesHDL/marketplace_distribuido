package com.sd.marcketplace.entrega.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	@EqualsAndHashCode.Include
    @Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String nome;

}
