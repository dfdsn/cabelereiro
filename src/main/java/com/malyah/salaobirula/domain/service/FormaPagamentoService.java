package com.malyah.salaobirula.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.FormaPagamentoNaoEncontradoException;
import com.malyah.salaobirula.domain.exception.FormaPagamentoStatusException;
import com.malyah.salaobirula.domain.model.FormaPagamento;
import com.malyah.salaobirula.domain.model.StatusFormaPagamento;
import com.malyah.salaobirula.domain.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	public FormaPagamento buscarOuFalhar(Long formaPagamentoId) {
		return formaPagamentoRepository.findById(formaPagamentoId)
				.orElseThrow(() -> new FormaPagamentoNaoEncontradoException(formaPagamentoId));
	}

	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return formaPagamentoRepository.save(formaPagamento);
	}

	public void excluir(Long formaPagamentoId) {
		formaPagamentoRepository.delete(buscarOuFalhar(formaPagamentoId));
	}

	public List<FormaPagamento> listar() {
		return formaPagamentoRepository.findAll();
	}

	public List<FormaPagamento> listarAtivos() {
		return formaPagamentoRepository.findByAtivoTrue();
	}
	
	public List<FormaPagamento> listarInativos() {
        return formaPagamentoRepository.findByAtivoFalse();
    }
	
	public FormaPagamento buscarPorNome(String nome) {
        return formaPagamentoRepository.findByNome(nome)
                .orElseThrow(() -> new FormaPagamentoNaoEncontradoException(nome));
    }

	public void ativar(Long formaPagamentoId) {
		FormaPagamento formaPagamento = buscarOuFalhar(formaPagamentoId);
		if (!formaPagamento.getAtivo()) {
			formaPagamento.ativar();
		} else {
			throw new FormaPagamentoStatusException(formaPagamento.getNome(), StatusFormaPagamento.ATIVO);
		}
	}
	
	public void desativar(Long formaPagamentoId) {
		FormaPagamento formaPagamento = buscarOuFalhar(formaPagamentoId);
		if (formaPagamento.getAtivo()) {
			formaPagamento.desativar();
		} else {
			throw new FormaPagamentoStatusException(formaPagamento.getNome(), StatusFormaPagamento.INATIVO);
		}
	}
	
	public void ativarTodas(List<Long> formaPagamentoIds) {
		formaPagamentoIds.forEach(this::ativar);
	}
	
	public void desativarTodas(List<Long> formaPagamentoIds) {
		formaPagamentoIds.forEach(this::desativar);
	}
	

}
