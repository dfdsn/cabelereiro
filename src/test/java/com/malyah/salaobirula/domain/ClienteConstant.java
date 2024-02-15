package com.malyah.salaobirula.domain;

import static com.malyah.salaobirula.domain.model.Sexo.FEMININO;
import static com.malyah.salaobirula.domain.model.Sexo.MASCULINO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.malyah.salaobirula.domain.model.Cliente;

public class ClienteConstant {

	public static final Cliente CLIENTE_GIULIA = 
				Cliente.builder()
					.id(1L)
					.nome("Giulia Bezerra")
					.sexo(FEMININO)
					.telefone("81999999999")
					.email("giulia@giulia.com")
					.credito(new BigDecimal(50))
					.debito(new BigDecimal(0))
					.ultimaVisita(LocalDate.now())
					.build();

	public static final Cliente CLIENTE_JOICE = 
			    Cliente.builder()
			    	.id(2L)
			    	.nome("Joice")
			    	.sexo(FEMININO)
			    	.telefone("81999999999")
			    	.email("giulia@giulia.com")
			    	.credito(new BigDecimal(50))
			    	.debito(new BigDecimal(0))
			    	.ultimaVisita(LocalDate.now())
			    	.build();

	public static final Cliente CLIENTE_DIEGO = 
		    Cliente.builder()
		    	.id(2L)
		    	.nome("Diego")
		    	.sexo(MASCULINO)
		    	.telefone("81999999999")
		    	.email("giulia@giulia.com")
		    	.credito(new BigDecimal(50))
		    	.debito(new BigDecimal(0))
		    	.ultimaVisita(LocalDate.now())
		    	.build();
	
	public static final Cliente INVALID_CLIENTE = 
            Cliente.builder()
                .id(3L)
            	.nome("")
                .sexo(FEMININO)
                .build();
	
	public static final List<Cliente> CLIENTES = Arrays.asList(CLIENTE_GIULIA, CLIENTE_JOICE, CLIENTE_DIEGO);
}
