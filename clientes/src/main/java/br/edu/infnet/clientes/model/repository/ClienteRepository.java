package br.edu.infnet.clientes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.clientes.model.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
}
