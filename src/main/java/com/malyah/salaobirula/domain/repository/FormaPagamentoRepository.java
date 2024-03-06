package com.malyah.salaobirula.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malyah.salaobirula.domain.model.FormaPagamento;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
	Optional<FormaPagamento> findByNome(String nome);

	List<FormaPagamento> findByAtivoTrue();

	List<FormaPagamento> findByAtivoFalse();

}
