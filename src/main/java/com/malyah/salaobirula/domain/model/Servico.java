package com.malyah.salaobirula.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Servico {
	
	@EqualsAndHashCode.Include
	@Id
	private Long id;
	private String nome;
	private String descricao;
	private String valor;
	private int duracao;
}
