package com.sd.marcketplace.view.form.cadastro.usuario;

public enum CadastroUsuarioOption {
	NONE(0L),
	CADASTRAR(1L),
	VOLTAR(2L);
	
	private Long value;
	
	CadastroUsuarioOption(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
