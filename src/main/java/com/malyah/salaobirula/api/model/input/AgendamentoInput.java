package com.malyah.salaobirula.api.model.input;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AgendamentoInput {
	
	private Long id;
	private LocalDate data;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFim;
	private ServicoInput servico;
	private ClienteInput cliente;
	private FuncionarioInput funcionario;
	private StatusAgendamentoInput status;
	private String observacao;
	private String valor;
	

}
