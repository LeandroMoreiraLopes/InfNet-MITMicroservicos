package br.edu.infnet.appAluguelVestuario.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAluguelVestuario.model.domain.Aluguel;

@Repository
public interface AluguelRepository extends CrudRepository<Aluguel, Integer>{

	@Query("from Aluguel a where a.usuario.id = :idUsuario")
	Collection<Aluguel> findAll(Integer idUsuario);
}
