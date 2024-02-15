package com.malyah.salaobirula.domain.exception;

public class ClienteNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(String mensagem) {
		super("Não existe um cadastro de cliente com email : " + mensagem);
	}

	public ClienteNaoEncontradoException(Long clienteId) {
		this(String.format("Não existe um cadastro de cliente com código %d", clienteId));
	}

}
