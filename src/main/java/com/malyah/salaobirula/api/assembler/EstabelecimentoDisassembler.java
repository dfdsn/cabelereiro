package com.malyah.salaobirula.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.input.EstabelecimentoInput;
import com.malyah.salaobirula.domain.model.Estabelecimento;

@Component
public class EstabelecimentoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public void copyToDomainObject(EstabelecimentoInput estabelecimentoInput, Estabelecimento estabelecimento) {
		modelMapper.map(estabelecimentoInput, estabelecimento);
	}
	
	public Estabelecimento toDomainObject(EstabelecimentoInput estabelecimentoInput) {
		return modelMapper.map(estabelecimentoInput, Estabelecimento.class);
	}
}
