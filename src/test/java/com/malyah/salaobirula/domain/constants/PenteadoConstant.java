package com.malyah.salaobirula.domain.constants;

import java.util.List;

import com.malyah.salaobirula.domain.model.Penteado;

public class PenteadoConstant {
	
	public static final Penteado PENTEADO = new Penteado(1L, "Penteado 1", "Penteado 1", null, "foto1", "1h");
	public static final Penteado PENTEADO_2 = new Penteado(2L, "Penteado 2", "Penteado 2", null, "foto2", "1h");
	public static final Penteado PENTEADO_3 = new Penteado(3L, "Penteado 3", "Penteado 3", null, "foto3", "1h");
	
	public static final List<Penteado> PENTEADOS = List.of(PENTEADO, PENTEADO_2, PENTEADO_3);
	

}
