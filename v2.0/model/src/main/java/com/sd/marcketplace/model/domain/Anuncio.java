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
@Table(name="tbs_anuncio")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_anuncio")
	private Long id;
	
	// FIXME fazer o mapeamento para a entidade VendedorProduto (tbs_vendedor_produto)
	private VendedorProduto vendedorProduto;
	
	@Column(name="dt_publicacao")
	private LocalDate dtPublicacao;

	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", vendedorProduto=" + vendedorProduto + ", dtPublicacao=" + dtPublicacao + "]";
	}
	
}
