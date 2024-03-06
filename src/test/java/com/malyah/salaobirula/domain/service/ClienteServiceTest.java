package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.ClienteConstant.CLIENTES;
import static com.malyah.salaobirula.domain.ClienteConstant.CLIENTE_GIULIA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.domain.model.Cliente;
import com.malyah.salaobirula.domain.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

	@InjectMocks
	private ClienteService clienteService;

	@Mock
	private ClienteRepository clienteRepository;

	@Test
	void adicionarCliente_retornaSucesso() {
		when(clienteRepository.save(CLIENTE_GIULIA)).thenReturn(CLIENTE_GIULIA);
		Cliente sut = clienteService.salvar(CLIENTE_GIULIA);
		assertThat(sut).isNotNull();
		assertThat(sut.getId()).isNotNull();
		assertThat(sut.getCredito()).isEqualTo(CLIENTE_GIULIA.getCredito());
		assertThat(sut.getDebito()).isEqualTo(CLIENTE_GIULIA.getDebito());
		assertThat(sut.getNome()).isEqualTo(CLIENTE_GIULIA.getNome());
		assertThat(sut.getSexo()).isEqualTo(CLIENTE_GIULIA.getSexo());
		assertThat(sut.getTelefone()).isEqualTo(CLIENTE_GIULIA.getTelefone());
		assertThat(sut.getEmail()).isEqualTo(CLIENTE_GIULIA.getEmail());
		assertThat(sut.getUltimaVisita()).isEqualTo(CLIENTE_GIULIA.getUltimaVisita());
		assertThat(sut).isEqualTo(CLIENTE_GIULIA);
	}

	@Test
	void adicionarClienteComErro_retornaExcecao() {
		when(clienteRepository.save(CLIENTE_GIULIA)).thenThrow(new RuntimeException("Erro de Banco de Dados"));
		assertThatThrownBy(() -> {
			clienteService.salvar(CLIENTE_GIULIA);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void listarClientes_retornaListaDeClientes() {
		when(clienteRepository.findAll()).thenReturn(CLIENTES);
		assertThat(clienteService.listarClientes()).isEqualTo(CLIENTES);
	}

	@Test
	void listarClientesVazio_retornaListaVazia() {
		when(clienteRepository.findAll()).thenReturn(null);
		assertThat(clienteService.listarClientes()).isNull();
	}

	@Test
	void buscarClientePorId_retornaCliente() {
		when(clienteRepository.findById(1L)).thenReturn(Optional.of(CLIENTE_GIULIA));
		assertThat(clienteService.buscarOuFalhar(1L)).isEqualTo(CLIENTE_GIULIA);
	}

	@Test
	void buscarClientePorIdInexistente_retornaVazio() {
		when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
		assertThatThrownBy(() -> {
			clienteService.buscarOuFalhar(1L);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void buscarClientePorEmail_retornaCliente() {
		when(clienteRepository.findByEmail("giulia@giulia.com")).thenReturn(Optional.of(CLIENTE_GIULIA));
		assertThat(clienteService.buscarClientePorEmail("giulia@giulia.com")).isEqualTo(CLIENTE_GIULIA);
	}
	
	@Test
	void buscarClientePorEmailInexistente_retornaVazio() {
        when(clienteRepository.findByEmail("erro@erro.com")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> {
            clienteService.buscarClientePorEmail("erro@erro.com");}).isInstanceOf(RuntimeException.class);
	}
	
	@Test
	void buscarClientePorNome_retornaCliente() {
		when(clienteRepository.findByNome("Giulia Bezerra")).thenReturn(Optional.of(CLIENTE_GIULIA));
		assertThat(clienteService.buscarClientePorNome("Giulia Bezerra")).isEqualTo(CLIENTE_GIULIA);
	}
	
	@Test
	void buscarClientePorNomeInexistente_retornaVazio() {
		when(clienteRepository.findByNome("erro")).thenReturn(Optional.empty());
		assertThatThrownBy(() -> {
			clienteService.buscarClientePorNome("erro");
		}).isInstanceOf(RuntimeException.class);
	}
	
	@Test
	void excluirCliente_retornaSucesso() {
		when(clienteRepository.findById(1L)).thenReturn(Optional.of(CLIENTE_GIULIA));
		clienteService.excluir(1L);
	}
	
	@Test
	void excluirClienteInexistente_retornaVazio() {
		when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
		assertThatThrownBy(() -> {
			clienteService.excluir(1L);
		}).isInstanceOf(RuntimeException.class);
	}
	
	@Test
	void editarCliente_retornaSucesso() {
	    // Mock do repositório para retornar o cliente desejado quando o método findById for chamado
	    when(clienteRepository.findById(CLIENTE_GIULIA.getId())).thenReturn(Optional.of(CLIENTE_GIULIA));

	    // Mock do repositório para retornar o cliente salvo quando o método save for chamado
//	    when(clienteRepository.save(CLIENTE_GIULIA)).thenReturn(CLIENTE_GIULIA);

	    Cliente sut = clienteService.editar(CLIENTE_GIULIA);
	    assertThat(sut).isNotNull();
	    assertThat(sut).isEqualTo(CLIENTE_GIULIA);
	}
	
	@Test
	void editarClienteComErro_retornaExcecao() {
		assertThatThrownBy(() -> {
			clienteService.editar(CLIENTE_GIULIA);
		}).isInstanceOf(RuntimeException.class);
	}
	

	

}
