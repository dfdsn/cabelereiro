package com.malyah.salaobirula.api.model.input;


public enum StatusFormaPagamentoInput {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	StatusFormaPagamentoInput(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
