package com.malyah.salaobirula.domain.constants;

import java.util.List;

import com.malyah.salaobirula.domain.model.FormaPagamento;

public class FormaPagamentoConstant {

	public static final FormaPagamento DINHEIRO = new FormaPagamento(1L, "Dinheiro", "Pagamento em dinheiro", false);
	public static final FormaPagamento PIX = new FormaPagamento(2L, "pix", "Pagamento em pix", false);
	public static final FormaPagamento CREDITO = new FormaPagamento(3L, "Credito", "Pagamento em credito", true);
	public static final FormaPagamento DEBITO = new FormaPagamento(4L, "Debito", "Pagamento em debito", true);
	
	
	public static List<FormaPagamento> PAGAMENTOS = List.of(DINHEIRO, PIX, CREDITO, DEBITO);
}
