package com.malyah.salaobirula.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.ProdutoNãoEncontradoException;
import com.malyah.salaobirula.domain.model.Produto;
import com.malyah.salaobirula.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void excluir(Long produtoId) {
		produtoRepository.deleteById(produtoId);
	}
	
	public Produto editar() {
		// TODO implementar a edição de produto
		return null;
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto buscarProdutoPorId(Long id) {
		return produtoRepository.findById(id).orElseThrow( () -> new ProdutoNãoEncontradoException(id) );
	}
	
	public Produto buscarProdutoPorNome(String nome) {
		return produtoRepository.findByNome(nome).orElseThrow( () -> new ProdutoNãoEncontradoException("Produto não encontrado") );
	}
	
}
