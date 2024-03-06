package com.malyah.salaobirula.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malyah.salaobirula.domain.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

//	List<Agendamento> findByClienteContaining(String cliente);

//	List<Agendamento> findByFuncionarioContaining(String funcionario);

//	List<Agendamento> findByStatusContaining(String status);

//	List<Agendamento> findByDataContaining(String data);

//	List<Agendamento> findByHoraContaining(String hora);

//	List<Agendamento> findByServicoContaining(String servico);

	Optional<List<Agendamento>> findByObservacaoContaining(String observacao);
	
	Optional<List<Agendamento>> findByValorContaining(String valor);


}
