package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.ServicoConstant.SERVICO;
import static com.malyah.salaobirula.domain.constants.ServicoConstant.SERVICOS;
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

import com.malyah.salaobirula.domain.exception.ServicoNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Servico;
import com.malyah.salaobirula.domain.repository.ServicoRepository;

@ExtendWith(MockitoExtension.class)
public class ServicoServiceTest {

	
	@InjectMocks
	private ServicoService servicoService;
	
	@Mock
	private ServicoRepository servicoRepository;
	
	
	
//	SALVAR E RETORNA SERVICO
	@Test
	public void salvarServico_retornaServico() {
		when(servicoRepository.save(SERVICO)).thenReturn(SERVICO);

		Servico servicoSalvo = servicoService.salvar(SERVICO);

		assertThat(servicoSalvo).isNotNull();
		assertThat(servicoSalvo.getId()).isNotNull();
		assertThat(servicoSalvo.getNome()).isEqualTo(SERVICO.getNome());
		assertThat(servicoSalvo.getDescricao()).isEqualTo(SERVICO.getDescricao());
		assertThat(servicoSalvo.getValor()).isEqualTo(SERVICO.getValor());
		assertThat(servicoSalvo.getDuracao()).isEqualTo(SERVICO.getDuracao());
	}
	
	
//	LISTAR SERVICOS
	@Test
	public void listarServicos_retornaListaDeServicos() {
		when(servicoRepository.findAll()).thenReturn(SERVICOS);

		List<Servico> servicos = servicoService.listar();

		assertThat(servicos).isNotNull();
		assertThat(servicos).isNotEmpty();
		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
		assertThat(servicos.get(0)).isEqualTo(SERVICO);
	}
	
//	BUSCAR SERVICO POR NOME

	@Test
	public void buscarServicoPorNome_retornaListaDeServicos() {
		when(servicoRepository.findByNomeContaining(SERVICO.getNome())).thenReturn(SERVICOS);

		List<Servico> servicos = servicoService.buscarPorNome(SERVICO.getNome());

		assertThat(servicos).isNotNull();
		assertThat(servicos).isNotEmpty();
		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
		assertThat(servicos.get(0)).isEqualTo(SERVICO);
	}
	
	//	BUSCAR SERVICO POR DESCRICAO
	
	@Test
	public void buscarServicoPorDescricao_retornaListaDeServicos() {
		when(servicoRepository.findByDescricaoContaining(SERVICO.getDescricao())).thenReturn(SERVICOS);

		List<Servico> servicos = servicoService.buscarPorDescricao(SERVICO.getDescricao());

		assertThat(servicos).isNotNull();
		assertThat(servicos).isNotEmpty();
		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
		assertThat(servicos.get(0)).isEqualTo(SERVICO);
	}
	
//	BUSCAR SERVICO POR VALOR
	
	@Test
	public void buscarServicoPorValor_retornaListaDeServicos() {
		when(servicoRepository.findByValorContaining(SERVICO.getValor())).thenReturn(SERVICOS);

		List<Servico> servicos = servicoService.buscarPorValor(SERVICO.getValor());

		assertThat(servicos).isNotNull();
		assertThat(servicos).isNotEmpty();
		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
		assertThat(servicos.get(0)).isEqualTo(SERVICO);
	}
	
//	buscar servico e retornar exceção caso não exista
	@Test
	public void buscarServicoInexistente_retornaExcecao() {
		when(servicoRepository.findById(SERVICO.getId())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> servicoService.buscarOuFalhar(SERVICO.getId()))
				.isInstanceOf(ServicoNaoEncontradoException.class);
		}
	
	
//	BUSCAR SERVICO POR DURACAO
//	@Test
//	public void buscarServicoPorDuracao_retornaListaDeServicos() {
//		when(servicoRepository.findByDuracaoContaining(SERVICO.getDuracao())).thenReturn(SERVICOS);
//
//		List<Servico> servicos = servicoService.buscarPorDuracao(SERVICO.getDuracao());
//
//		assertThat(servicos).isNotNull();
//		assertThat(servicos).isNotEmpty();
//		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
//		assertThat(servicos.get(0)).isEqualTo(SERVICO);
//	}
	
//	BUSCAR SERVICO POR CATEGORIA
//	@Test
//	public void buscarServicoPorCategoria_retornaListaDeServicos() {
//		when(servicoRepository.findByCategoriaContaining(SERVICO.getCategoria())).thenReturn(SERVICOS);
//
//		List<Servico> servicos = servicoService.buscarPorCategoria(SERVICO.getCategoria());
//
//		assertThat(servicos).isNotNull();
//		assertThat(servicos).isNotEmpty();
//		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
//		assertThat(servicos.get(0)).isEqualTo(SERVICO);
//	}
//	
////	BUSCAR SERVICO POR TIPO
//	@Test
//	public void buscarServicoPorTipo_retornaListaDeServicos() {
//		when(servicoRepository.findByTipoContaining(SERVICO.getTipo())).thenReturn(SERVICOS);
//
//		List<Servico> servicos = servicoService.buscarPorTipo(SERVICO.getTipo());
//
//		assertThat(servicos).isNotNull();
//		assertThat(servicos).isNotEmpty();
//		assertThat(servicos.size()).isEqualTo(SERVICOS.size());
//		assertThat(servicos.get(0)).isEqualTo(SERVICO);
//	}
	
	//	BUSCAR SERVICO POR ID
	@Test
	public void buscarServicoPorId_retornaServico() {
		when(servicoRepository.findById(SERVICO.getId())).thenReturn(java.util.Optional.of(SERVICO));

		Servico servico = servicoService.buscarOuFalhar(SERVICO.getId());

		assertThat(servico).isNotNull();
		assertThat(servico.getId()).isEqualTo(SERVICO.getId());
		assertThat(servico.getNome()).isEqualTo(SERVICO.getNome());
		assertThat(servico.getDescricao()).isEqualTo(SERVICO.getDescricao());
		assertThat(servico.getValor()).isEqualTo(SERVICO.getValor());
		assertThat(servico.getDuracao()).isEqualTo(SERVICO.getDuracao());
	}
	
	//	EDITAR SERVICO
	@Test
	public void editarServico_retornaServico() {
		when(servicoRepository.save(SERVICO)).thenReturn(SERVICO);

		Servico servicoSalvo = servicoService.salvar(SERVICO);

		assertThat(servicoSalvo).isNotNull();
		assertThat(servicoSalvo.getId()).isNotNull();
		assertThat(servicoSalvo.getNome()).isEqualTo(SERVICO.getNome());
		assertThat(servicoSalvo.getDescricao()).isEqualTo(SERVICO.getDescricao());
		assertThat(servicoSalvo.getValor()).isEqualTo(SERVICO.getValor());
		assertThat(servicoSalvo.getDuracao()).isEqualTo(SERVICO.getDuracao());
	}
	
	//	EXCLUIR SERVICO
	@Test
	public void excluirServico_retornaVoid() {
		servicoService.excluir(SERVICO.getId());
	}
	
	
	
}
