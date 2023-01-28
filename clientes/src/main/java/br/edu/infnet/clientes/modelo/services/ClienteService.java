package br.edu.infnet.clientes.modelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.clientes.model.entities.Cliente;
import br.edu.infnet.clientes.model.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente getByCodigo(Long codigo) {
		return clienteRepository.findById(codigo).get();
	}
}
