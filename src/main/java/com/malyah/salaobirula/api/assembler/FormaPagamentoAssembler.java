package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.FormaPagamentoView;
import com.malyah.salaobirula.domain.model.FormaPagamento;

@Component
public class FormaPagamentoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public FormaPagamentoView toModel(FormaPagamento formaPagamento) {
		return modelMapper.map(formaPagamento, FormaPagamentoView.class);
	}
	
	public List<FormaPagamentoView> toCollectionModel(List<FormaPagamento> formasPagamento) {
		return formasPagamento.stream().map(formaPagamento -> toModel(formaPagamento)).collect(Collectors.toList());
	}
	
}
