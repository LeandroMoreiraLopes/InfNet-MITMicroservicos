package br.edu.infnet.appAluguelVestuario.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAluguelVestuario.model.domain.Aluguel;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.repository.AluguelRepository;
//import br.edu.infnet.appAluguelVestuario.model.test.AppImpressao;

@Service
public class AluguelService {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	public void incluir(Aluguel aluguel)	{
		
		aluguelRepository.save(aluguel);
		
		//AppImpressao.relatorio("Inclusão do aluguel " + aluguel.getItemAlugado() + " realizada com sucesso", aluguel);
	}
	
	public Collection<Aluguel> obterLista(){
		return (Collection<Aluguel>) aluguelRepository.findAll();
	}
	
	public Collection<Aluguel> obterLista(Usuario usuario){
		return (Collection<Aluguel>) aluguelRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id) {
		aluguelRepository.deleteById(id);
	}
}
