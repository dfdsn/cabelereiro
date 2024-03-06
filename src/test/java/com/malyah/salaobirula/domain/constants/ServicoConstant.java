package com.malyah.salaobirula.domain.constants;

import java.util.List;

import com.malyah.salaobirula.domain.model.Servico;


public class ServicoConstant {
	
	
	public static final Servico SERVICO = new Servico(1L, "Corte", "Corte de cabelo", "30", 30 );
	public static final Servico SERVICO_2 = new Servico(2L, "Manicure", "Manicure", "20", 60 );
	public static final Servico SERVICO_3 = new Servico(3L, "Pedicure", "Pedicure", "20", 60 );
	public static final Servico SERVICO_4 = new Servico(4L, "Sobrancelha", "Sobrancelha", "20", 30 );
	
	public static final List<Servico> SERVICOS = List.of(SERVICO, SERVICO_2, SERVICO_3, SERVICO_4);
	
}
