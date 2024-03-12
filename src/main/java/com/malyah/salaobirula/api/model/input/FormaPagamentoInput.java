package com.malyah.salaobirula.api.model.input;

import lombok.Data;

@Data
public class FormaPagamentoInput {
	
	private Long id;
	private String nome;
	private String descricao;
	private Boolean ativo;
	
}
