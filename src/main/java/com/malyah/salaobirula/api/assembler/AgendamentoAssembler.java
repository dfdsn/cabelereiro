package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.AgendamentoView;
import com.malyah.salaobirula.domain.model.Agendamento;

@Component
public class AgendamentoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public AgendamentoView toModel(Agendamento agendamento) {
		return modelMapper.map(agendamento, AgendamentoView.class);
	}
	
	public List<AgendamentoView> toCollectionModel(List<Agendamento> agendamentos) {
		return agendamentos.stream().map(agendamento -> toModel(agendamento)).collect(Collectors.toList());
	}
	
}
