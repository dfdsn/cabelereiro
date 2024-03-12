package com.malyah.salaobirula.api.model.input;

import lombok.Data;


@Data
public class EstabelecimentoInput {

	private Long id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String email;
	private TipoEstabelecimentoInput tipo;
	private StatusEstabelecimentoInput status;
	private String imagem;
	private String descricao;
	private String horarioFuncionamento;
}
