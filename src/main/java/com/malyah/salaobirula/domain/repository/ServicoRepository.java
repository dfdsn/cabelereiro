package com.malyah.salaobirula.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malyah.salaobirula.domain.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	
	Optional<Servico> findByNome(String nome);
	Optional<Servico> findByDescricao(String descricao);
	Optional<Servico> findByValor(String valor);
	List<Servico> findByNomeContaining(String nome);
	List<Servico> findByDescricaoContaining(String descricao);
	List<Servico> findByValorContaining(String valor);
//	List<Servico> findByDuracaoContaining(int duracao);
//	List<Servico> findByCategoriaContaining(String categoria);
//	List<Servico> findByTipoContaining(String tipo);
//	List<Servico> findByStatusContaining(String status);
	
	
}
