package br.edu.infnet.appAluguelVestuario.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAluguelVestuario.model.domain.Vestuario;

@Repository
public interface VestuarioRepository extends CrudRepository<Vestuario, Integer>{

	@Query("from Vestuario v where v.usuario.id = :idUsuario")
	Collection<Vestuario> findAll(Integer idUsuario);

}
