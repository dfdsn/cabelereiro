package com.malyah.salaobirula.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.input.FuncionarioInput;
import com.malyah.salaobirula.domain.model.Funcionario;

@Component
public class FuncionarioDisassembler {

	@Autowired
	public ModelMapper modelMapper;
	
	public void copyToDomainObject(FuncionarioInput funcionarioInput, Funcionario funcionario) {
		funcionario.setNome(funcionarioInput.getNome());
		funcionario.setTelefone(funcionarioInput.getTelefone());
		funcionario.setCargo(funcionarioInput.getCargo());
	}
	
	public Funcionario toDomainObject(FuncionarioInput funcionarioInput) {
		return modelMapper.map(funcionarioInput, Funcionario.class);
	}
}
