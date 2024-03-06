package com.malyah.salaobirula.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.ServicoNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Servico;
import com.malyah.salaobirula.domain.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;

	public List<Servico> listar() {
		return servicoRepository.findAll();
	}
	
	public Servico salvar(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	public void excluir(Long id) {
		servicoRepository.deleteById(id);
	}
	
	public Servico buscarOuFalhar(Long id) {
		return servicoRepository.findById(id).orElseThrow(() -> new ServicoNaoEncontradoException(id));
	}
	
	public List<Servico> buscarPorNome(String nome) {
		return servicoRepository.findByNomeContaining(nome);
	}
	
	public List<Servico> buscarPorDescricao(String descricao) {
		return servicoRepository.findByDescricaoContaining(descricao);
	}
	
	public List<Servico> buscarPorValor(String valor) {
		return servicoRepository.findByValorContaining(valor);
	}
	
//	public List<Servico> buscarPorDuracao(int duracao) {
//		return servicoRepository.findByDuracaoContaining(duracao);
//	}
//	
//	public List<Servico> buscarPorCategoria(String categoria) {
//		return servicoRepository.findByCategoriaContaining(categoria);
//	}
//	
//	public List<Servico> buscarPorTipo(String tipo) {
//		return servicoRepository.findByTipoContaining(tipo);
//	}
//	
//	public List<Servico> buscarPorStatus(String status) {
//		return servicoRepository.findByStatusContaining(status);
//	}
	
	
}
