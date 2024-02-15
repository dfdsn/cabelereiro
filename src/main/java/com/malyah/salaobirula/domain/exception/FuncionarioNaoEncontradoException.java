package com.malyah.salaobirula.domain.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public FuncionarioNaoEncontradoException(Long funcionarioId) {
		this(String.format("Não existe um cadastro de funcionário com código %d", funcionarioId));
	}

}
