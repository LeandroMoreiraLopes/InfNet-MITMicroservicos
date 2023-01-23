package br.edu.infnet.appAluguelVestuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.domain.Vestuario;
import br.edu.infnet.appAluguelVestuario.model.repository.VestuarioRepository;

@Service
public class VestuarioService {
	
	@Autowired
	private VestuarioRepository vestuarioRepository;
	
	public List<Vestuario> obterLista(){
		return (List<Vestuario>) vestuarioRepository.findAll();
	}
	
	public List<Vestuario> obterLista(Usuario usuario){
		return (List<Vestuario>) vestuarioRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id){
		vestuarioRepository.deleteById(id);
	}
}
