package com.malyah.salaobirula.api.model.output;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class AgendamentoView {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private LocalDate data;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFim;
	@OneToOne
	private ServicoView servico;
	@OneToOne
	private ClienteView cliente;
	@OneToOne
	private FuncionarioView funcionario;
	private StatusAgendamentoView status;
	private String observacao;
	private String valor;
	

}
