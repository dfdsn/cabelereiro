package com.malyah.salaobirula.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malyah.salaobirula.domain.model.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{

	Optional<Estabelecimento> findByNome(String nome);

}
