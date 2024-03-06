package com.malyah.salaobirula.domain.exception;

public class PenteadoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PenteadoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PenteadoNaoEncontradoException(Long penteadoId) {
		this(String.format("Não existe um cadastro de penteado com código %d", penteadoId));
	}

}
