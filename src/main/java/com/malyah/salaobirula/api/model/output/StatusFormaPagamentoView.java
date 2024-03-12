package com.malyah.salaobirula.api.model.output;


public enum StatusFormaPagamentoView {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	StatusFormaPagamentoView(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
