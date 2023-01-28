package br.edu.infnet.catalogo.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.catalogo.model.entities.Vestuario;
import br.edu.infnet.catalogo.model.repository.VestuarioRepository;

@Service
public class VestuarioService {

	@Autowired
	private VestuarioRepository vestuarioRepository;
	
	public List<Vestuario> getAll(){
		return (List<Vestuario>) vestuarioRepository.findAll();
	}
}
