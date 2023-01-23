package br.edu.infnet.appAluguelVestuario.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appAluguelVestuario.model.domain.Calcado;

@Repository
public interface CalcadoRepository extends CrudRepository<Calcado, Integer>{

	@Query("from Calcado c where c.usuario.id =:idUsuario")
	Collection<Calcado> findAll(Integer idUsuario);

}
