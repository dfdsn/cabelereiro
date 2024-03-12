package com.malyah.salaobirula.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.input.AgendamentoInput;
import com.malyah.salaobirula.domain.model.Agendamento;
import com.malyah.salaobirula.domain.model.Cliente;
import com.malyah.salaobirula.domain.model.Servico;

@Component
public class AgendamentoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Agendamento toDomainObject(AgendamentoInput agendamentoInput) {
		return modelMapper.map(agendamentoInput, Agendamento.class);
	}
	
	public void copyToDomainObject(AgendamentoInput agendamentoInput, Agendamento agendamento) {
		// Para evitar org.hibernate.HibernateException: identifier of an instance of
		// com.algaworks.algafood.domain.model.Estado was altered from 1 to 2
//		agendamento.setCliente(new Cliente());
		agendamento.setServico(new Servico());

		modelMapper.map(agendamentoInput, agendamento);
	}
}
