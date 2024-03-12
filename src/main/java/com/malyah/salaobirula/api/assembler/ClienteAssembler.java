package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.ClienteView;
import com.malyah.salaobirula.domain.model.Cliente;

@Component
public class ClienteAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public ClienteView toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteView.class);
	}
	
	public List<ClienteView> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream().map(cliente -> toModel(cliente)).collect(Collectors.toList());
	}
}
