package br.edu.infnet.catalogo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.catalogo.model.entities.Vestuario;

@Repository
public interface VestuarioRepository extends CrudRepository<Vestuario, Long>{

}
