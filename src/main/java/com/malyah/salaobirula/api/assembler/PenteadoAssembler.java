package com.malyah.salaobirula.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.salaobirula.api.model.output.PenteadoView;
import com.malyah.salaobirula.domain.model.Penteado;

@Component
public class PenteadoAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public PenteadoView toModel(
			Penteado penteado) {
		return modelMapper.map(penteado, PenteadoView.class);
	}
	
	public List<PenteadoView> toCollectionModel(List<Penteado> penteados) {
		return penteados.stream().map(penteado -> toModel(penteado)).collect(Collectors.toList());
	}
}
