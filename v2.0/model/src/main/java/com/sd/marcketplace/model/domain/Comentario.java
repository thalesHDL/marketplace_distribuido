package com.sd.marcketplace.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbs_comentario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_comentario")
	private Long id;
	
	// FIXME fazer o mapeamento para a entidade Usuario (tbs_usuario)
	private Usuario usuario;
	
	@Column(name="tx_descricao")
	private String descricao;
	
	@Column(name="dt_publicacao")
	private LocalDate dtPublicacao;
	
}
