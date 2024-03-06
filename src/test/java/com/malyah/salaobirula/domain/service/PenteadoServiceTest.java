package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.PenteadoConstant.PENTEADO;
import static com.malyah.salaobirula.domain.constants.PenteadoConstant.PENTEADOS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.domain.exception.PenteadoNaoEncontradoException;
import com.malyah.salaobirula.domain.repository.PenteadoRepository;

@ExtendWith(MockitoExtension.class)
public class PenteadoServiceTest {

	@InjectMocks
	private PenteadoService penteadoService;

	@Mock
	private PenteadoRepository penteadoRepository;

	@Test
	public void adicionarPenteado_retornaSucesso() {
		when(penteadoRepository.save(PENTEADO)).thenReturn(PENTEADO);
		penteadoService.salvar(PENTEADO);
		assertThat(penteadoService.salvar(PENTEADO)).isNotNull();
		assertThat(penteadoService.salvar(PENTEADO)).isEqualTo(PENTEADO);
		
	}

	@Test
	public void excluirPenteado_retornaSucesso() {
//		when(penteadoRepository.findById(1L)).thenReturn(Optional.of(PENTEADO));
		
		penteadoService.excluir(1L);
	}
	
	@Test
	public void listarPenteado_retornaSucesso() {
		when(penteadoRepository.findAll()).thenReturn(PENTEADOS);
		assertThat(penteadoService.listar()).isNotNull();
		assertThat(penteadoService.listar()).isEqualTo(PENTEADOS);
	}
	
	@Test
	public void buscarPenteadoPorId_retornaSucesso() {
		when(penteadoRepository.findById(1L)).thenReturn(Optional.of(PENTEADO) );
		assertThat(penteadoService.buscarOuFalhar(1L)).isNotNull();
		assertThat(penteadoService.buscarOuFalhar(1L)).isEqualTo(PENTEADO);
	}
	
	@Test
	public void atualizarPenteado_retornaSucesso() {
		when(penteadoRepository.findById(1L)).thenReturn(Optional.of(PENTEADO));
		when(penteadoRepository.save(PENTEADO)).thenReturn(PENTEADO);
		assertThat(penteadoService.atualizar(1L, PENTEADO)).isNotNull();
		assertThat(penteadoService.atualizar(1L, PENTEADO)).isEqualTo(PENTEADO);
	}
	
	@Test
	public void buscarPenteadoPorNome_retornaSucesso() {
		when(penteadoRepository.findByNome("Penteado 1")).thenReturn(Optional.of(PENTEADO));
		assertThat(penteadoService.buscarPenteadoPorNome("Penteado 1")).isNotNull();
		assertThat(penteadoService.buscarPenteadoPorNome("Penteado 1")).isEqualTo(PENTEADO);
	}
	
	@Test
	public void atualizarFotoPenteado_retornaSucesso() {
		when(penteadoRepository.findById(1L)).thenReturn(Optional.of(PENTEADO));
		when(penteadoRepository.save(PENTEADO)).thenReturn(PENTEADO);
		penteadoService.atualizarFoto(1L, "foto");
	}
	
	@Test
	public void buscarPenteadoPorId_retornaExcecao() {
		when(penteadoRepository.findById(1L)).thenReturn(Optional.empty());
		assertThatThrownBy(() -> penteadoService.buscarOuFalhar(1L)).isInstanceOf(PenteadoNaoEncontradoException.class);
	}
	
	@Test
	public void buscarPenteadoPorNome_retornaExcecao() {
		when(penteadoRepository.findByNome("Penteado 1")).thenReturn(Optional.empty());
		assertThatThrownBy(() -> penteadoService.buscarPenteadoPorNome("Penteado 1"))
				.isInstanceOf(PenteadoNaoEncontradoException.class);
	}
	
}
