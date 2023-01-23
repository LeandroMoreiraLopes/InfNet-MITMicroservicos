package br.edu.infnet.appAluguelVestuario.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAluguelVestuario.model.domain.Roupa;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Integer>{

	@Query("from Roupa r where r.usuario.id = :idUsuario")
	Collection<Roupa> findAll(Integer idUsuario);
	
	@Query("from Roupa r where r.id = :idRoupa")
	Collection<Roupa> find(Integer idRoupa);

}
