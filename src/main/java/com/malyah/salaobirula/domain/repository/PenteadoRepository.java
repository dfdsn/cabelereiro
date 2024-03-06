package com.malyah.salaobirula.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malyah.salaobirula.domain.model.Penteado;

@Repository
public interface PenteadoRepository extends JpaRepository<Penteado, Long>{

	Optional<Penteado> findByNome(String nome);

}
