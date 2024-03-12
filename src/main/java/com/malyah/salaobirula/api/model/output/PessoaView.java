package com.malyah.salaobirula.api.model.output;

import java.time.LocalDate;

import lombok.Data;

@Data
public abstract class PessoaView {
	
	private Long id;
	private String nome;
	private SexoView sexo;
	private String telefone;
	private String email;
	private LocalDate dataNascimento;
	private String observacao;


}
