package com.sd.marcketplace.entrega.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbs_comentario_anuncio")
@Getter
@Setter
@NoArgsConstructor
public class ComentarioAnuncio {
	// FIXME criar a chave composta e mapear para os atributos
	
	// FIXME fazer o mapeamento para a entidade Comentario (tbs_comentario)
	private Comentario comentario;
	
	// FIXME fazer o mapeamento para a entidade Anuncio (tbs_anuncio)
	private Anuncio anuncio;

}
