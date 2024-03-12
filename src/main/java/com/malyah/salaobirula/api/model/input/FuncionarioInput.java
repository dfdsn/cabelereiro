package com.malyah.salaobirula.api.model.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FuncionarioInput extends PessoaInput{

	private String cargo;
	private BigDecimal salario;
	private String dataAdmissao;
	private String dataDemissao;
	private String status;
}
