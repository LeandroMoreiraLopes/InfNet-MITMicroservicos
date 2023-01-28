package br.edu.infnet.appAluguelVestuario.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAluguelVestuario.model.domain.Calcado;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.repository.CalcadoRepository;

@Service
public class CalcadoService {
	
	@Autowired
	private CalcadoRepository calcadoRepository;
	
	//private static Map<Integer, Calcado> mapaCalcado = new HashMap<Integer, Calcado>();
	//private static Integer id = 1;
	
	public void incluir(Calcado calcado)	{
		
		calcadoRepository.save(calcado);
		
		//calcado.setId(id++);
		//mapaCalcado.put(calcado.getId(), calcado);
		
		//AppImpressao.relatorio("Inclusão do calçado " + calcado.getNome() + " realizada com sucesso", calcado);
	}
	
	public Collection<Calcado> obterLista(){
		return (Collection<Calcado>)calcadoRepository.findAll();
		
		//return mapaCalcado.values();
	}
	
	public Collection<Calcado> obterLista(Usuario usuario){
		return (Collection<Calcado>)calcadoRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id) {
		calcadoRepository.deleteById(id);
		
		//mapaCalcado.remove(id);
	}
}
