package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.EstabelecimentoView;
import com.malyah.salaobirula.domain.model.Estabelecimento;

@Component
public class EstabelecimentoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public EstabelecimentoView toModel(Estabelecimento estabelecimento) {
		return modelMapper.map(estabelecimento, EstabelecimentoView.class);
	}
	
	public List<EstabelecimentoView> toCollectionModel(List<Estabelecimento> estabelecimentos) {
		return estabelecimentos.stream().map(estabelecimento -> toModel(estabelecimento)).collect(Collectors.toList());
	}
	
}
