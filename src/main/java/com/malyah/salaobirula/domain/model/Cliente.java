package com.malyah.salaobirula.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class Cliente extends Pessoa{

	private BigDecimal credito;
	private BigDecimal debito;	
	private LocalDate ultimaVisita;
	
}
