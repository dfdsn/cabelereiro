package com.malyah.salaobirula.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.FuncionarioNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Funcionario;
import com.malyah.salaobirula.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	    @Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public void excluir(Long funcionarioId) {
		funcionarioRepository.deleteById(funcionarioId);
	}
	
	public Funcionario buscarOuFalhar(Long funcionarioId) {
        return funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(funcionarioId));
	}
	
	public Funcionario buscarPorEmail(String email) {
		return funcionarioRepository.findByEmail(email).orElseThrow(() -> new FuncionarioNaoEncontradoException(email));
	}

	public Funcionario editar(Funcionario funcionario) {
//		TODO: Implementar a edição de funcionários
		return null;
	}
	
	
	
}
