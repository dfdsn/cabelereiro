package com.malyah.salaobirula.api.model.input;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
public class ServicoInput
{
	
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String nome;
	private String descricao;
	private String valor;
	private int duracao;
}
