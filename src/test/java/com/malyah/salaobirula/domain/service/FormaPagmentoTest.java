package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.FormaPagamentoConstant.CREDITO;
import static com.malyah.salaobirula.domain.constants.FormaPagamentoConstant.DINHEIRO;
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
import com.malyah.salaobirula.domain.exception.FormaPagamentoStatusException;
import com.malyah.salaobirula.domain.model.FormaPagamento;
import com.malyah.salaobirula.domain.repository.FormaPagamentoRepository;

@ExtendWith(MockitoExtension.class)
public class FormaPagmentoTest {
	
	@InjectMocks
	private FormaPagamentoService formaPagamentoService;
	
	@Mock
	private FormaPagamentoRepository formaPagamentoRepository;

	
	@Test
	void cadastrarFormaPagamento_retornaSucesso() {
		when(formaPagamentoRepository.save(DINHEIRO)).thenReturn(DINHEIRO);

		FormaPagamento formaPagamentoSalva = formaPagamentoService.salvar(DINHEIRO);

		assertThat(formaPagamentoSalva).isNotNull();
		assertThat(formaPagamentoSalva.getNome()).isEqualTo("Dinheiro");
		assertThat(formaPagamentoSalva.getDescricao()).isEqualTo("Pagamento em dinheiro");
	}
	
	@Test
	void excluirFormaPagamento_retornaSucesso() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(DINHEIRO));

		formaPagamentoService.excluir(1L);
	}
	
	@Test
	void listarFormaPagamento_retornaSucesso() {
		when(formaPagamentoRepository.findAll()).thenReturn(List.of(DINHEIRO, CREDITO));

		List<FormaPagamento> formasPagamento = formaPagamentoService.listar();

		assertThat(formasPagamento).isNotEmpty();
		assertThat(formasPagamento).hasSize(2);
	}
	
	@Test
	void listarFormaPagamentoAtivos_retornaSucesso() {
		when(formaPagamentoRepository.findByAtivoTrue()).thenReturn(List.of(DINHEIRO));

		List<FormaPagamento> formasPagamento = formaPagamentoService.listarAtivos();

		assertThat(formasPagamento).isNotEmpty();
		assertThat(formasPagamento).hasSize(1);
	}
	
	@Test
	void listarFormaPagamentoInativos_retornaSucesso() {
		when(formaPagamentoRepository.findByAtivoFalse()).thenReturn(List.of(CREDITO));

		List<FormaPagamento> formasPagamento = formaPagamentoService.listarInativos();

		assertThat(formasPagamento).isNotEmpty();
		assertThat(formasPagamento).hasSize(1);
	}
	
	
	@Test
	void ativarFormaPagamento_retornaSucesso() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(CREDITO));
//		when(formaPagamentoRepository.save(CREDITO)).thenReturn(CREDITO);
		CREDITO.setAtivo(false);
		formaPagamentoService.ativar(1L);
		
		assertThat(CREDITO.getAtivo()).isTrue();
	}
	
	@Test
	void desativarFormaPagamento_retornaSucesso() {
        when(formaPagamentoRepository.findById(DINHEIRO.getId())).thenReturn(Optional.of(DINHEIRO));
        DINHEIRO.setAtivo(true);
        CREDITO.setAtivo(true);
        formaPagamentoService.desativar(DINHEIRO.getId());
        assertThat(DINHEIRO.getAtivo()).isFalse();
	}
	
	@Test
	void ativarTodasFormaPagamento_retornaSucesso() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(CREDITO));
		when(formaPagamentoRepository.findById(2L)).thenReturn(Optional.of(DINHEIRO));
		CREDITO.setAtivo(false);
		DINHEIRO.setAtivo(false);

		formaPagamentoService.ativarTodas(List.of(1L, 2L));

		assertThat(CREDITO.getAtivo()).isTrue();
		assertThat(DINHEIRO.getAtivo()).isTrue();
	}
	
	@Test
	void desativarTodasFormaPagamento_retornaSucesso() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(CREDITO));
		when(formaPagamentoRepository.findById(2L)).thenReturn(Optional.of(DINHEIRO));
		CREDITO.setAtivo(true);
		DINHEIRO.setAtivo(true);

		formaPagamentoService.desativarTodas(List.of(1L, 2L));

		assertThat(CREDITO.getAtivo()).isFalse();
		assertThat(DINHEIRO.getAtivo()).isFalse();
	}
	
	@Test
	void buscarPorNome_retornaSucesso() {
		when(formaPagamentoRepository.findByNome("Dinheiro")).thenReturn(Optional.of(DINHEIRO));

		FormaPagamento formaPagamento = formaPagamentoService.buscarPorNome("Dinheiro");

		assertThat(formaPagamento).isNotNull();
		assertThat(formaPagamento.getNome()).isEqualTo("Dinheiro");
		assertThat(formaPagamento.getDescricao()).isEqualTo("Pagamento em dinheiro");
	}
	
	@Test
	void buscarOuFalhar_retornaSucesso() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(DINHEIRO));

		FormaPagamento formaPagamento = formaPagamentoService.buscarOuFalhar(1L);

		assertThat(formaPagamento).isNotNull();
		assertThat(formaPagamento.getNome()).isEqualTo("Dinheiro");
		assertThat(formaPagamento.getDescricao()).isEqualTo("Pagamento em dinheiro");
	}
	
	@Test
	void buscarOuFalhar_retornaExcecao() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.empty());

		try {
			formaPagamentoService.buscarOuFalhar(1L);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(FormaPagamentoNaoEncontradoException.class);
		}
	}
	
	@Test
	void ativarFormaPagamento_retornaExcecao() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(DINHEIRO));
		DINHEIRO.setAtivo(true);

		try {
			formaPagamentoService.ativar(1L);
		} catch (Exception e) {
			assertThat(e).isInstanceOf(FormaPagamentoStatusException.class);
		}
	}
	
	@Test
	void desativarFormaPagamento_retornaExcecao() {
		when(formaPagamentoRepository.findById(1L)).thenReturn(Optional.of(DINHEIRO));
		DINHEIRO.setAtivo(false);
		assertThatThrownBy(() -> formaPagamentoService.desativar(1L)).isInstanceOf(FormaPagamentoStatusException.class);
		
	}

	@Test
	void buscarPorNome_retornaExcecao() {
		when(formaPagamentoRepository.findByNome("Dinheiro")).thenReturn(Optional.empty());

		assertThatThrownBy(() -> formaPagamentoService.buscarPorNome("Dinheiro")).isInstanceOf(FormaPagamentoNaoEncontradoException.class);
	}
	
	
}
