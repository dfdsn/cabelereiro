package com.malyah.salaobirula.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.input.ServicoInput;
import com.malyah.salaobirula.domain.model.Servico;

@Component
public class ServicoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Servico toDomainObject(ServicoInput servicoInput) {
		return modelMapper.map(servicoInput, Servico.class);
	}
	
	public void copyToDomainObject(ServicoInput servicoInput, Servico servico) {
		modelMapper.map(servicoInput, servico);
	}
	
}
