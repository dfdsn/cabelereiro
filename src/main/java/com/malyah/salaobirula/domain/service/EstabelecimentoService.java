package com.malyah.salaobirula.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.EstabelecimentoNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Estabelecimento;
import com.malyah.salaobirula.domain.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	
	public Estabelecimento salvar(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}
	
	public void excluir(Long estabelecimentoId) {
		estabelecimentoRepository.deleteById(estabelecimentoId);
	}
	
	public Estabelecimento editar() {
		// TODO implementar a edição de estabelecimento
		return null;
	}
	
	public List<Estabelecimento> listarEstabelecimentos() {
		return estabelecimentoRepository.findAll();
	}
	
	public Estabelecimento buscarEstabelecimentoPorId(Long id) {
		return estabelecimentoRepository.findById(id).orElseThrow( () -> new EstabelecimentoNaoEncontradoException(id) );
	}
	
	public Estabelecimento buscarEstabelecimentoPorNome(String nome) {
		return estabelecimentoRepository.findByNome(nome).orElseThrow( () -> new EstabelecimentoNaoEncontradoException(nome) );  
	}
	
	
	
}
