package com.malyah.salaobirula.domain.constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.malyah.salaobirula.domain.model.Agendamento;
import com.malyah.salaobirula.domain.model.StatusAgendamento;

public class AgendamentoConstant {


	

	
	
	public static final Agendamento AGENDAMENTO = new Agendamento(1L, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now().plusHours(1), ServicoConstant.SERVICO, ClienteConstant.CLIENTE2, FuncionarioConstant.FUNCIONARIO2, StatusAgendamento.AGENDADO, "observacao", "valor");
	public static final Agendamento AGENDAMENTO2 = new Agendamento(2L, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now().plusHours(1), ServicoConstant.SERVICO, ClienteConstant.CLIENTE3, FuncionarioConstant.FUNCIONARIO2, StatusAgendamento.AGENDADO, "observacao", "valor");
	public static final Agendamento AGENDAMENTO3 = new Agendamento(3L, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now().plusHours(1), ServicoConstant.SERVICO, ClienteConstant.CLIENTE2, FuncionarioConstant.FUNCIONARIO2, StatusAgendamento.AGENDADO, "observacao", "valor");
	
	
	
	public static final List<Agendamento> AGENDAMENTOS = Arrays.asList(AGENDAMENTO, AGENDAMENTO2, AGENDAMENTO3);
}