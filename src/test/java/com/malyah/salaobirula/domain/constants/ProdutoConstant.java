package com.malyah.salaobirula.domain.constants;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.malyah.salaobirula.domain.model.Produto;

public class ProdutoConstant {
	
	public static final Produto PRODUTO1 = new Produto(1L, "Produto 1", "Descrição do produto 1", new BigDecimal(20), true, true, "imagem1.jpg", "123456789"	);
	public static final Produto PRODUTO2 = new Produto(2L, "Produto 2", "Descrição do produto 2", new BigDecimal(20), true, true, "imagem1.jpg", "123456789"	);
	public static final Produto PRODUTO3 = new Produto(3L, "Produto 3", "Descrição do produto 3", new BigDecimal(20), true, true, "imagem1.jpg", "123456789"	);

	
	public static final List<Produto> PRODUTOS = Arrays.asList(PRODUTO1, PRODUTO2, PRODUTO3);
}
