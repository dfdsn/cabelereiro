package com.malyah.salaobirula.api.model.output;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
public class ClienteView extends PessoaView{

	private BigDecimal credito;
	private BigDecimal debito;	
	private LocalDate ultimaVisita;
	
}
