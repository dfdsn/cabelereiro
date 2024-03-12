package com.malyah.salaobirula.api.model.output;

public enum StatusAgendamentoView {

	AGENDADO("Agendado"), CANCELADO("Cancelado"), CONCLUIDO("Concluído");

	private String descricao;

	StatusAgendamentoView(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
