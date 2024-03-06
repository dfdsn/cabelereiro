package com.malyah.salaobirula.domain.exception;

public class ServicoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ServicoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ServicoNaoEncontradoException(Long servicoId) {
		this(String.format("Não existe um cadastro de serviço com código %d", servicoId));
	}

}
