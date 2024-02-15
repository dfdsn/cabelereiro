package com.malyah.salaobirula.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class Funcionario extends Pessoa{

	private String cargo;
	private BigDecimal salario;
	private String dataAdmissao;
	private String dataDemissao;
	private String status;
}
