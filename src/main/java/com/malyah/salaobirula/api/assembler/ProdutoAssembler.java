package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.ProdutoView;
import com.malyah.salaobirula.domain.model.Produto;

@Component
public class ProdutoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoView toModel(Produto produto) {
		return modelMapper.map(produto, ProdutoView.class);
	}
	
	public List<ProdutoView> toCollectionModel(List<Produto> produtos) {
		return produtos.stream().map(produto -> toModel(produto)).collect(Collectors.toList());
	}

}
