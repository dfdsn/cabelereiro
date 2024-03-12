package com.malyah.salaobirula.api.model.output;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FuncionarioView extends PessoaView{

	private String cargo;
	private BigDecimal salario;
	private String dataAdmissao;
	private String dataDemissao;
	private String status;
}
