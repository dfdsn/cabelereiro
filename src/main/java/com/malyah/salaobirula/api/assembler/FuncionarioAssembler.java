package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.FuncionarioView;
import com.malyah.salaobirula.domain.model.Funcionario;

@Component
public class FuncionarioAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public FuncionarioView toModel(Funcionario funcionario) {
		return modelMapper.map(funcionario, FuncionarioView.class);
	}
	
	public List<FuncionarioView> toCollectionModel(List<Funcionario> funcionarios) {
		return funcionarios.stream().map(funcionario -> toModel(funcionario)).collect(Collectors.toList());
	}
	
}
