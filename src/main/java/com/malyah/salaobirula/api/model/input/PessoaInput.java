package com.malyah.salaobirula.api.model.input;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
public abstract class PessoaInput {
	
	private Long id;
	private String nome;
	private SexoInput sexo;
	private String telefone;
	private String email;
	private LocalDate dataNascimento;
	private String observacao;


}
