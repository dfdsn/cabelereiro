package com.malyah.salaobirula.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDate data;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFim;
	@OneToOne
	private Servico servico;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Funcionario funcionario;
	private StatusAgendamento status;
	private String observacao;
	private String valor;
	

}
