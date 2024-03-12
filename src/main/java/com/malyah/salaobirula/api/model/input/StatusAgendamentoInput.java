package com.malyah.salaobirula.api.model.input;

public enum StatusAgendamentoInput {

	AGENDADO("Agendado"), CANCELADO("Cancelado"), CONCLUIDO("Concluído");

	private String descricao;

	StatusAgendamentoInput(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
