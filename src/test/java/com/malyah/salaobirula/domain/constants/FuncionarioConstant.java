package com.malyah.salaobirula.domain.constants;

import java.util.Arrays;
import java.util.List;

import com.malyah.salaobirula.domain.model.Funcionario;
import com.malyah.salaobirula.domain.model.Sexo;

public class FuncionarioConstant {
	
	public static final Funcionario FUNCIONARIO = Funcionario.builder()
            .id(1L)
            .nome("Funcionario")
            .email("func@func.com")
            .salario(null)
            .telefone("123456789")
            .dataAdmissao( "2021-01-01")
            .cargo("cabeleireiro")
            .sexo(Sexo.MASCULINO)
            .status("ativo")
            .build();

	
	public static final Funcionario FUNCIONARIO2 = Funcionario.builder()
            .id(2L)
            .nome("Funcionario2")
            .email("func@func.com")
            .salario(null)
            .telefone("123456789")
            .dataAdmissao( "2021-01-01")
            .cargo("cabeleireiro")
            .sexo(Sexo.MASCULINO)
            .status("ativo")
            .build();


	public static final Funcionario FUNCIONARIO3 = Funcionario.builder()
            .id(3L)
            .nome("Funcionario3")
            .email("func@func.com")
            .salario(null)
            .telefone("123456789")
            .dataAdmissao( "2021-01-01")
            .cargo("cabeleireiro")
            .sexo(Sexo.MASCULINO)
            .status("ativo")
            .build();


	public static final List<Funcionario> FUNCIONARIOS = Arrays.asList(FUNCIONARIO, FUNCIONARIO2, FUNCIONARIO3);
}
