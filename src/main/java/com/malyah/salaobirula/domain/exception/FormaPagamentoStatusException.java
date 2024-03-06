package com.malyah.salaobirula.domain.exception;

import com.malyah.salaobirula.domain.model.StatusFormaPagamento;

public class FormaPagamentoStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FormaPagamentoStatusException(String mensagem) {
		super(mensagem);
	}


	public FormaPagamentoStatusException(String  formaPagamentoNome, StatusFormaPagamento status) {
		this(String.format("Forma de pagamento com o nome %s já está %s", formaPagamentoNome, status.getDescricao()));
	}
}
