package com.malyah.salaobirula.domain.model;


public enum StatusFormaPagamento {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	StatusFormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
