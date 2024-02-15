package com.malyah.salaobirula.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.malyah.salaobirula.domain.exception.ClienteNaoEncontradoException;
import com.malyah.salaobirula.domain.model.Cliente;
import com.malyah.salaobirula.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {

		
		 if (!clienteRepository.findById(clienteId).isPresent()) {
	            throw new RuntimeException("Cliente não encontrado.");
	        }
	}
	
	public Cliente editar(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.findById(cliente.getId())
								.orElseThrow(() -> new ClienteNaoEncontradoException(cliente.getId()));
		return cliente;
	}
	
	public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
	}
	
	public Cliente buscarClientePorEmail(String email) {
		return clienteRepository.findByEmail(email).get();
	}
	
	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id).orElseThrow( () -> new ClienteNaoEncontradoException(id));
	}
	
	public Cliente buscarClientePorNome(String nome) {
		return clienteRepository.findByNome(nome).orElseThrow(() -> new ClienteNaoEncontradoException(nome));
	}
}
