package com.malyah.salaobirula.domain.model;

public enum StatusAgendamento {

	AGENDADO("Agendado"), CANCELADO("Cancelado"), CONCLUIDO("Concluído");

	private String descricao;

	StatusAgendamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
