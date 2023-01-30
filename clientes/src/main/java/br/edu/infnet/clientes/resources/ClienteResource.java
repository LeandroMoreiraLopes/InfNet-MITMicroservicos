package br.edu.infnet.clientes.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.clientes.model.entities.Cliente;
import br.edu.infnet.clientes.model.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	private Logger log = LoggerFactory.getLogger(ClienteResource.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{codigo}")
	public Cliente getCliente(@PathVariable Long codigo)
	{
		log.info("Chamada para API de cliente com codigo {}", codigo);
		return clienteService.getByCodigo(codigo);
	}

}
