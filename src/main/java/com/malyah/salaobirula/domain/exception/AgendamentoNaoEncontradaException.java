package com.malyah.salaobirula.domain.exception;

public class AgendamentoNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AgendamentoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public AgendamentoNaoEncontradaException(Long id) {
		this(String.format("Não existe um cadastro de agenda com código %d", id));
	}

}
