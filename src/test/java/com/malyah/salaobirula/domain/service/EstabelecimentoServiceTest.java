package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.EstabelecimentoConstant.ESTABELECIMENTOS;
import static com.malyah.salaobirula.domain.constants.EstabelecimentoConstant.ESTABELECIMENTO_BIRULA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.domain.exception.EstabelecimentoNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Estabelecimento;
import com.malyah.salaobirula.domain.repository.EstabelecimentoRepository;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {
	

	@InjectMocks
	private EstabelecimentoService estabelecimentoService;
	
	@Mock
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Test
	void salvar_estabelecimento_retorna_sucesso() {
		when(estabelecimentoRepository.save(ESTABELECIMENTO_BIRULA)).thenReturn(ESTABELECIMENTO_BIRULA);
		
		Estabelecimento sut = estabelecimentoService.salvar(ESTABELECIMENTO_BIRULA);
		assertThat(sut).isNotNull();
		assertThat(sut.getId()).isNotNull();
		
	}
	
	@Test
	void excluir_estabelecimento_retorna_sucesso() {
		estabelecimentoService.excluir(1L);
	}
	
	@Test
	void editar_estabelecimento_retorna_sucesso() {
		estabelecimentoService.editar();
	}
	
	@Test
	void listarEstabelecimentos_retorna_sucesso() {
		when(estabelecimentoRepository.findAll()).thenReturn(ESTABELECIMENTOS);
		assertThat(estabelecimentoService.listarEstabelecimentos().size()).isEqualTo(3);
	}
	
	
	@Test
	void buscarEstabelecimentoPorId_retorna_sucesso() {
		when(estabelecimentoRepository.findById(1L)).thenReturn(java.util.Optional.of(ESTABELECIMENTO_BIRULA));
		assertThat(estabelecimentoService.buscarEstabelecimentoPorId(1L)).isEqualTo(ESTABELECIMENTO_BIRULA);
	}
	
	@Test
	void buscarEstabelecimentoPorNome_retorna_sucesso() {
		when(estabelecimentoRepository.findByNome("Salão Birula"))
				.thenReturn(Optional.of(ESTABELECIMENTO_BIRULA));
		assertThat(estabelecimentoService.buscarEstabelecimentoPorNome("Salão Birula"))
				.isEqualTo(ESTABELECIMENTO_BIRULA);
	}
	
	@Test
	void buscarEstabelecimentoPorNome_retorna_excecao() {
		when(estabelecimentoRepository.findByNome("Salão Birula")).thenReturn(null);
		assertThatThrownBy(() -> {
			estabelecimentoService.buscarEstabelecimentoPorNome("Salão Birula");
		}).isInstanceOf(RuntimeException.class);
		
		
	}
	
	@Test
	void buscarEstabelecimentoPorIdInexistente_retorna_excecao() {
		when(estabelecimentoRepository.findById(1L)).thenReturn(Optional.empty());
		assertThatThrownBy(() -> {
			estabelecimentoService.buscarEstabelecimentoPorId(1L);
		}).isInstanceOf(RuntimeException.class);
	}
	
	@Test
    void buscarEstabelecimentoPorNome_quandoNaoEncontrado_lancaExcecao() {
        String nome = "Estabelecimento Inexistente";

        when(estabelecimentoRepository.findByNome(nome)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> estabelecimentoService.buscarEstabelecimentoPorNome(nome))
                .isInstanceOf(EstabelecimentoNaoEncontradoException.class)
                .hasMessage("Estabelecimento Inexistente");
    }
	
	
	

}
