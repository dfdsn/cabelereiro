package com.malyah.salaobirula.domain.exception;

public class ProdutoNãoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ProdutoNãoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoNãoEncontradoException(Long produtoId) {
		this(String.format("Não existe um cadastro de produto com código %d", produtoId));
	}
	
}
