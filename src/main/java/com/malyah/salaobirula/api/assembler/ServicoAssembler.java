package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.ServicoView;
import com.malyah.salaobirula.domain.model.Servico;

@Component
public class ServicoAssembler {

		
	private ModelMapper modelMapper;
	
	public ServicoView toModel(Servico servico) {
		return modelMapper.map(servico, ServicoView.class);
	}
	
	public List<ServicoView> toCollectionModel(List<Servico> servicos) {
		return servicos.stream().map(servico -> toModel(servico)).collect(Collectors.toList());
	}
}
