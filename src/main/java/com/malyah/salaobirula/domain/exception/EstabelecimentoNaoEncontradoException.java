package com.malyah.salaobirula.domain.exception;

public class EstabelecimentoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EstabelecimentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EstabelecimentoNaoEncontradoException(Long estabelecimentoId) {
        this(String.format("Não existe um cadastro de estabelecimento com código %d", estabelecimentoId));
    }
    
 
}
