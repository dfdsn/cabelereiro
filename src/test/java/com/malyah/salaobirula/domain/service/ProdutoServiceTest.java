package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.ProdutoConstant.PRODUTO1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.domain.exception.ProdutoNãoEncontradoException;
import com.malyah.salaobirula.domain.model.Produto;
import com.malyah.salaobirula.domain.repository.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {
	
	@InjectMocks
	private ProdutoService produtoService;

	@Mock
	private ProdutoRepository produtoRepository;
	
	@Test
	void salvar_produto_retorna_sucesso() {
		when(produtoRepository.save(PRODUTO1)).thenReturn(PRODUTO1);

		Produto sut = produtoService.salvar(PRODUTO1);
		assertThat(sut).isNotNull();
		assertThat(sut.getId()).isNotNull();
	}
	
	@Test
	void excluir_produto_retorna_sucesso() {
		produtoService.excluir(1L);
	}
	
	@Test
	void editar_produto_retorna_sucesso() {
		produtoService.editar();
	}
	
	@Test
	void buscarProdutoPorId_retorna_sucesso() {
		when(produtoRepository.findById(1L)).thenReturn(java.util.Optional.of(PRODUTO1));
		assertThat(produtoService.buscarProdutoPorId(1L)).isEqualTo(PRODUTO1);
	}
	
	@Test
	void buscarProdutoPorNome_retorna_sucesso() {
		when(produtoRepository.findByNome("Produto 1")).thenReturn(java.util.Optional.of(PRODUTO1));
		assertThat(produtoService.buscarProdutoPorNome("Produto 1")).isEqualTo(PRODUTO1);
	}
	
	@Test
	void buscarProdutoPorNome_retorna_excecao() {
		when(produtoRepository.findByNome("Produto 1")).thenReturn(java.util.Optional.empty());
		assertThatThrownBy(() -> produtoService.buscarProdutoPorNome("Produto 1"))
				.isInstanceOf(ProdutoNãoEncontradoException.class);
	}
	
	@Test
	void buscarProdutoPorId_retorna_excecao() {
		when(produtoRepository.findById(1L)).thenReturn(java.util.Optional.empty());
		assertThatThrownBy(() -> produtoService.buscarProdutoPorId(1L))
				.isInstanceOf(ProdutoNãoEncontradoException.class);
	}
	
	
	
	
}
