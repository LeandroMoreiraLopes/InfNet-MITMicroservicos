package br.edu.infnet.appAluguelVestuario.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAluguelVestuario.model.domain.Acessorio;

@Repository
public interface AcessorioRepository extends CrudRepository<Acessorio, Integer>{

	@Query("from Acessorio a where a.usuario.id =:idUsuario")
	Collection<Acessorio> findAll(Integer idUsuario);

}
