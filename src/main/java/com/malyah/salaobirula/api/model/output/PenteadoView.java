package com.malyah.salaobirula.api.model.output;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PenteadoView {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private String foto;
	private String duracao;
	
	
}
