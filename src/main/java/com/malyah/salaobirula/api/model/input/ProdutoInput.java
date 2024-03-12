package com.malyah.salaobirula.api.model.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoInput {
	
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Boolean ativo;
	private Boolean disponivel;
	private String imagem;
	private String codigo;

}
