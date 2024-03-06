package com.malyah.salaobirula.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.PenteadoNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Penteado;
import com.malyah.salaobirula.domain.repository.PenteadoRepository;

@Service
public class PenteadoService {

	@Autowired
	private PenteadoRepository penteadoRepository;
	
	public void excluir(Long penteadoId) {
		penteadoRepository.deleteById(penteadoId);
	}
	
	public Penteado salvar(Penteado penteado) {
		return penteadoRepository.save(penteado);
	}
	
	public List<Penteado> listar() {
		return penteadoRepository.findAll();
	}
	
	public Penteado buscarOuFalhar(Long penteadoId) {
		return penteadoRepository.findById(penteadoId)
				.orElseThrow(() -> new PenteadoNaoEncontradoException(penteadoId));
	}
	
	public Penteado buscarPenteadoPorNome(String nome) {
		return penteadoRepository.findByNome(nome).orElseThrow(() -> new PenteadoNaoEncontradoException("Penteado não encontrado"));
	}
	
	public Penteado atualizar(Long penteadoId, Penteado penteado) {
		Penteado penteadoAtual = buscarOuFalhar(penteadoId);
		penteadoAtual.setNome(penteado.getNome());
		penteadoAtual.setDescricao(penteado.getDescricao());
		penteadoAtual.setPreco(penteado.getPreco());
		penteadoAtual.setFoto(penteado.getFoto());
		penteadoAtual.setDuracao(penteado.getDuracao());
		return salvar(penteadoAtual);
	}
	
	public void atualizarFoto(Long penteadoId, String foto) {
		Penteado penteado = buscarOuFalhar(penteadoId);
		penteado.setFoto(foto);
		salvar(penteado);
	}
}
