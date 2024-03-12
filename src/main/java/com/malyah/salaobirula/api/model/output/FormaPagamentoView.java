package com.malyah.salaobirula.api.model.output;

import lombok.Data;

@Data
public class FormaPagamentoView {
	
	private Long id;
	private String nome;
	private String descricao;
	private Boolean ativo;
	
}
