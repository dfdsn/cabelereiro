package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.AgendamentoConstant.AGENDAMENTO;
import static com.malyah.salaobirula.domain.constants.AgendamentoConstant.AGENDAMENTOS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.domain.exception.FormaPagamentoNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Agendamento;
import com.malyah.salaobirula.domain.repository.AgendamentoRepository;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

	@InjectMocks
	private AgendamentoService agendamentoService;
	
	@Mock
	private AgendamentoRepository agendamentoRepository;
	
	@Test
	public void listarAgendamentos_retornaListaDeAgendamentos() {
		when(agendamentoRepository.findAll()).thenReturn(AGENDAMENTOS);

		List<Agendamento> agendamentos = agendamentoService.listar();

		assertThat(agendamentos).isNotNull();
		assertThat(agendamentos).isNotEmpty();
		assertThat(agendamentos.size()).isEqualTo(AGENDAMENTOS.size());
		assertThat(agendamentos.get(0)).isEqualTo(AGENDAMENTO);
	}
	
//	@Test
//	public void salvarAgendamento_retornaAgendamento() {
//		when(agendamentoRepository.save(AGENDAMENTO)).thenReturn(AGENDAMENTO);
//
//		Agendamento sut = agendamentoService.salvar(AGENDAMENTO);
//
//		assertThat(sut).isNotNull();
//		assertThat(sut.getId()).isNotNull();
//		assertThat(sut.getCliente()).isEqualTo(AGENDAMENTO.getCliente());
//		assertThat(sut.getServico()).isEqualTo(AGENDAMENTO.getServico());
//		assertThat(sut.getData()).isEqualTo(AGENDAMENTO.getData());
//		assertThat(sut.getHorarioInicio()).isEqualTo(AGENDAMENTO.getHorarioInicio());
//		assertThat(sut.getValor()).isEqualTo(AGENDAMENTO.getValor());
//	}
	
	@Test
	public void buscarAgendamento_retorneAgendamento() {
		when(agendamentoRepository.findById(AGENDAMENTO.getId())).thenReturn(java.util.Optional.of(AGENDAMENTO));

		Agendamento agendamento = agendamentoService.buscarOuFalhar(AGENDAMENTO.getId());

		assertThat(agendamento).isNotNull();
		assertThat(agendamento.getId()).isEqualTo(AGENDAMENTO.getId());
		assertThat(agendamento.getCliente()).isEqualTo(AGENDAMENTO.getCliente());
		assertThat(agendamento.getServico()).isEqualTo(AGENDAMENTO.getServico());
		assertThat(agendamento.getData()).isEqualTo(AGENDAMENTO.getData());
		assertThat(agendamento.getHorarioInicio()).isEqualTo(AGENDAMENTO.getHorarioInicio());
		assertThat(agendamento.getValor()).isEqualTo(AGENDAMENTO.getValor());
	}
	
	@Test
	public void excluirAgendamento() {
		agendamentoService.excluir(AGENDAMENTO.getId());
	}
	
	@Test
	public void buscarAgendamentoPorObservacao_retornaListaDeAgendamentos() {
		when(agendamentoRepository.findByObservacaoContaining(AGENDAMENTO.getObservacao())).thenReturn(Optional.of( AGENDAMENTOS));

		List<Agendamento> agendamentos = agendamentoService.buscarPorObservacao(AGENDAMENTO.getObservacao());

		assertThat(agendamentos).isNotNull();
		assertThat(agendamentos).isNotEmpty();
		assertThat(agendamentos.size()).isEqualTo(AGENDAMENTOS.size());
		assertThat(agendamentos.get(0)).isEqualTo(AGENDAMENTO);
	}
	
	@Test
	public void buscarAgendamentoPorValor_retornaListaDeAgendamentos() {
		when(agendamentoRepository.findByValorContaining(AGENDAMENTO.getValor())).thenReturn(Optional.of( AGENDAMENTOS));

		List<Agendamento> agendamentos = agendamentoService.buscarPorValor(AGENDAMENTO.getValor());

		assertThat(agendamentos).isNotNull();
		assertThat(agendamentos).isNotEmpty();
		assertThat(agendamentos.size()).isEqualTo(AGENDAMENTOS.size());
		assertThat(agendamentos.get(0)).isEqualTo(AGENDAMENTO);
	}
	
	@Test
	public void buscarAgendamentoPorId_retornaExcecao() {
		when(agendamentoRepository.findById(AGENDAMENTO.getId())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> agendamentoService.buscarOuFalhar(AGENDAMENTO.getId()))
				.isInstanceOf(RuntimeException.class);

	}
	
	@Test
	public void buscarAgendamentoPorObservacao_retornaExcecao() {
		when(agendamentoRepository.findByObservacaoContaining(AGENDAMENTO.getObservacao())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> agendamentoService.buscarPorObservacao(AGENDAMENTO.getObservacao()))
				.isInstanceOf(RuntimeException.class);
	}
	
	@Test
	public void buscarPorValor_retornaExcecao() {
		when(agendamentoRepository.findByValorContaining(AGENDAMENTO.getValor())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> agendamentoService.buscarPorValor(AGENDAMENTO.getValor()))
				.isInstanceOf(RuntimeException.class);
	}
	
//	when(formaPagamentoRepository.findByNome("Dinheiro")).thenReturn(Optional.empty());
//
//	assertThatThrownBy(() -> formaPagamentoService.buscarPorNome("Dinheiro")).isInstanceOf(FormaPagamentoNaoEncontradoException.class);
//}
}
