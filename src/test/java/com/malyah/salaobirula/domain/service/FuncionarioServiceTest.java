package com.malyah.salaobirula.domain.service;

import static com.malyah.salaobirula.domain.constants.FuncionarioConstant.FUNCIONARIO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.salaobirula.domain.model.Funcionario;
import com.malyah.salaobirula.domain.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

	@InjectMocks
	private FuncionarioService funcionarioService;
	
	
	@Mock
	private FuncionarioRepository funcionarioRepository;
	
	@Test
	void salvar_funcionario_retorna_sucesso() {
		when(funcionarioRepository.save(FUNCIONARIO)).thenReturn(FUNCIONARIO);

		Funcionario sut = funcionarioService.salvar(FUNCIONARIO);
		assertThat(sut).isNotNull();
		assertThat(sut.getId()).isNotNull();

	}
	
	@Test
	void excluir_funcionario_retorna_sucesso() {
		funcionarioService.excluir(1L);
	}
	
	@Test
	void editar_funcionario_retorna_sucesso() {
		funcionarioService.editar(FUNCIONARIO);
	}
	
	@Test
	void buscarFuncionarioPorId_retorna_sucesso() {
		when(funcionarioRepository.findById(1L)).thenReturn(java.util.Optional.of(FUNCIONARIO));
		assertThat(funcionarioService.buscarOuFalhar(1L)).isEqualTo(FUNCIONARIO);
	}
	
	@Test
	void buscarFuncionarioPorEmail_retorna_sucesso() {
        when(funcionarioRepository.findByEmail("func@func.com")).thenReturn(Optional.of(FUNCIONARIO));
        assertThat(funcionarioService.buscarPorEmail("func@func.com")).isEqualTo(FUNCIONARIO);
	}
	
	@Test
	void buscarFuncionarioPorEmail_retorna_excecao() {
        when(funcionarioRepository.findByEmail("1@1.com")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> funcionarioService.buscarPorEmail("1@1.com"))
                .isInstanceOf(RuntimeException.class);
	}
	
	@Test
	void buscarFuncionarioPorId_retorna_excecao() {
		when(funcionarioRepository.findById(1L)).thenReturn(Optional.empty());
		assertThatThrownBy(() -> funcionarioService.buscarOuFalhar(1L)).isInstanceOf(RuntimeException.class);
	}

	

}
