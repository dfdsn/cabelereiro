package com.malyah.salaobirula.api.model.output;

import lombok.Data;


@Data
public class EstabelecimentoView {

	private Long id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String email;
	private TipoEstabelecimentoView tipo;
	private StatusEstabelecimentoView status;
	private String imagem;
	private String descricao;
	private String horarioFuncionamento;
}
