package com.malyah.salaobirula.domain.constants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.malyah.salaobirula.domain.model.Cliente;
import com.malyah.salaobirula.domain.model.Sexo;

public class ClienteConstant {

	public static final Long CLIENTE_ID = 1L;
	public static final String CLIENTE_NOME = "Diego";
	public static final String CLIENTE_SEXO = "M";
	public static final String CLIENTE_TELEFONE = "999999999";
	public static final String CLIENTE_EMAIL = "EMAIL@EMAIL.COM";
	public static final LocalDate CLIENTE_DATA_NASCIMENTO = LocalDate.of(1990, 1, 1);
	public static final String CLIENTE_OBSERVACAO = "Observacao";
	public static final BigDecimal CLIENTE_CREDITO = new BigDecimal(0);
	public static final BigDecimal CLIENTE_DEBITO = new BigDecimal(0);
	public static final LocalDate CLIENTE_ULTIMA_VISITA = LocalDate.now();


	public static final Cliente CLIENTE = Cliente.builder().id(CLIENTE_ID).nome(CLIENTE_NOME).sexo(Sexo.MASCULINO)
			.telefone(CLIENTE_TELEFONE).email(CLIENTE_EMAIL).dataNascimento(CLIENTE_DATA_NASCIMENTO)
			.observacao(CLIENTE_OBSERVACAO).credito(CLIENTE_CREDITO).debito(CLIENTE_DEBITO)
			.ultimaVisita(CLIENTE_ULTIMA_VISITA).build();
	
	public static final Cliente CLIENTE2 = Cliente.builder().id(2L).nome("Maria").sexo(Sexo.FEMININO)
            .telefone("999999999").email("maria@email.com")
            .dataNascimento(LocalDate.of(1990, 1, 1)).observacao("Observacao")
            .credito(new BigDecimal(0)).debito(new BigDecimal(0))
            .ultimaVisita(LocalDate.now()).build();
	
	public static final Cliente CLIENTE3 = Cliente.builder().id(3L).nome("Jose").sexo(Sexo.MASCULINO)
			            .telefone("999999999").email("terceiro@email.com")
			            .dataNascimento(LocalDate.of(1990, 1, 1)).observacao("Observacao")
			            .credito(new BigDecimal(0)).debito(new BigDecimal(0))
			            .ultimaVisita(LocalDate.now()).build();
	
	public static final List<Cliente> CLIENTES = List.of(CLIENTE, CLIENTE2, CLIENTE3);
	
}
