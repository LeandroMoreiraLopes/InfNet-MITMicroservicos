package br.edu.infnet.appAluguelVestuario.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAluguelVestuario.model.domain.Acessorio;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.repository.AcessorioRepository;

@Service
public class AcessorioService {
	
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	//private static Map<Integer, Acessorio> mapaAcessorio = new HashMap<Integer, Acessorio>();
	//private static Integer id = 1;
	
	public void incluir(Acessorio acessorio)	{
		
		acessorioRepository.save(acessorio);
		
		//acessorio.setId(id++);
		//mapaAcessorio.put(acessorio.getId(), acessorio);
		
		//AppImpressao.relatorio("Inclusão de acessorio " + acessorio.getNome() + " realizada com sucesso", acessorio);
	}
	
	public Collection<Acessorio> obterLista(){
		return (Collection<Acessorio>) acessorioRepository.findAll();
		
		//return mapaAcessorio.values();
	}
	
	public Collection<Acessorio> obterLista(Usuario usuario){
		return (Collection<Acessorio>) acessorioRepository.findAll(usuario.getId());
		
		//return mapaAcessorio.values();
	}
	
	public void excluir(Integer id) {
		acessorioRepository.deleteById(id);
		
		//mapaAcessorio.remove(id);
	}
}
