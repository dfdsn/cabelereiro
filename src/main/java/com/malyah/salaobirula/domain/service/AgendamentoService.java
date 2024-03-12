package com.malyah.salaobirula.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.AgendamentoNaoEncontradaException;
import com.malyah.salaobirula.domain.model.Agendamento;
import com.malyah.salaobirula.domain.model.Cliente;
import com.malyah.salaobirula.domain.model.Funcionario;
import com.malyah.salaobirula.domain.model.Servico;
import com.malyah.salaobirula.domain.model.StatusAgendamento;
import com.malyah.salaobirula.domain.repository.AgendamentoRepository;
@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private ServicoService servicoService;
	
	
	
	

	public List<Agendamento> listar() {
		return agendamentoRepository.findAll();
	}
	
	public Agendamento salvar(Agendamento agenda) {
		
		Cliente cliente 		= clienteService.buscarOuFalhar(agenda.getCliente().getId());
		Funcionario funcionario = funcionarioService.buscarOuFalhar(agenda.getFuncionario().getId());
		Servico servico 		= servicoService.buscarOuFalhar(agenda.getServico().getId());
		
		agenda.setCliente(cliente);
		agenda.setFuncionario(funcionario);
		agenda.setServico(servico);
		agenda.setHorarioFim(agenda.getHorarioInicio().plusMinutes(servico.getDuracao()) );
//        TODO:CONFIGURAR UM ENDPOINT PARA O STATUS DO AGENDAMENTO
		agenda.setStatus(StatusAgendamento.AGENDADO);
		
        String elev;
        int numero = 10;
        elev = Integer.toString(numero);
        
		return agendamentoRepository.save(agenda);
	}
	
	public void excluir(Long id) {
		agendamentoRepository.deleteById(id);
	}
	
	public Agendamento buscarOuFalhar(Long id) {
       return agendamentoRepository.findById(id).orElseThrow( () -> new AgendamentoNaoEncontradaException(id) );
}
	
//public List<Agendamento> buscarPorCliente(String cliente) {
//	return agendaRepository.findByClienteContaining(cliente);
//}
//
//public List<Agendamento> buscarPorFuncionario(String funcionario) {
//	return agendaRepository.findByFuncionarioContaining(funcionario);
//}
//
//public List<Agendamento> buscarPorStatus(String status) {
//	return agendaRepository.findByStatusContaining(status);
//}
//
//public List<Agendamento> buscarPorData(String data) {
//	return agendaRepository.findByDataContaining(data);
//}

//public List<Agendamento> buscarPorHora(String hora) {
//	return agendaRepository.findByHoraContaining(hora);
//}

//public List<Agendamento> buscarPorServico(String servico) {
//	return agendaRepository.findByServicoContaining(servico);
//}

public List<Agendamento> buscarPorObservacao(String observacao) {
	return agendamentoRepository.findByObservacaoContaining(observacao).orElseThrow( () -> new AgendamentoNaoEncontradaException(observacao) );
}																		

public List<Agendamento> buscarPorValor(String valor) {
	return agendamentoRepository.findByValorContaining(valor).orElseThrow( () -> new AgendamentoNaoEncontradaException(valor) );
}






}