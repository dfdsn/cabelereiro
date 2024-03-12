package com.malyah.salaobirula.api.model.input;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;


@Data
public class ClienteInput extends PessoaInput{

	private BigDecimal credito;
	private BigDecimal debito;	
	private LocalDate ultimaVisita;
	
}
