package com.malyah.salaobirula.api.model.output;

import lombok.Data;

@Data
public class ServicoView {
	
	private Long id;
	private String nome;
	private String descricao;
	private String valor;
	private int duracao;
}
