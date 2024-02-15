package com.malyah.salaobirula.domain.constants;

import java.util.Arrays;
import java.util.List;

import com.malyah.salaobirula.domain.model.Estabelecimento;
import com.malyah.salaobirula.domain.model.StatusEstabelecimento;
import com.malyah.salaobirula.domain.model.TipoEstabelecimento;

public class EstabelecimentoConstant {
	
	public static final Estabelecimento ESTABELECIMENTO_BIRULA = new Estabelecimento(1L, "Salão Birula", "123456789", "Rua do Birula, 123", "123456789", "email@email.com", 
            TipoEstabelecimento.MATRIX, StatusEstabelecimento.ABERTO, "imagem.jpg", "Salão de Beleza Birula", "08:00 - 18:00");



public static final Estabelecimento ESTABELECIMENTO2 = new Estabelecimento(2L, "Salão 2", "123456789", "Rua do Birula, 123", "123456789", "segundo@segundo.com", 
            TipoEstabelecimento.MATRIX, StatusEstabelecimento.ABERTO, "imagem.jpg", "Salão de Beleza Birula", "08:00 - 18:00");


public static final Estabelecimento ESTABELECIMENTO3 = new Estabelecimento(3L, "Salão 3", "123456789",
		"Rua do Birula, 123", "123456789", "terceiro@terceiro.com", TipoEstabelecimento.MATRIX,
		StatusEstabelecimento.ABERTO, "imagem.jpg", "Salão de Beleza Birula", "08:00 - 18:00");


public static final List<Estabelecimento> ESTABELECIMENTOS = Arrays.asList(ESTABELECIMENTO_BIRULA, ESTABELECIMENTO2, ESTABELECIMENTO3);

}