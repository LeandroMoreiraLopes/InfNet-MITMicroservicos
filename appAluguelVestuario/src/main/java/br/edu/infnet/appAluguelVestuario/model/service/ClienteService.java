package br.edu.infnet.appAluguelVestuario.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAluguelVestuario.model.domain.Cliente;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.repository.ClienteRepository;
import br.edu.infnet.appAluguelVestuario.model.test.AppImpressao;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//private static Map<Integer, Cliente> mapaCliente = new HashMap<Integer, Cliente>();
	//private static Integer id = 1;
	
	public void incluir(Cliente cliente)	{
		
		clienteRepository.save(cliente);
		
//		cliente.setId(id++);
//		mapaCliente.put(cliente.getId(), cliente);
		
		AppImpressao.relatorio("Inclusão de cliente " + cliente.getNome() + " realizada com sucesso", cliente);
	}
	
	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>)clienteRepository.findAll();
		
		//return mapaCliente.values();
	}
	
	public Collection<Cliente> obterLista(Usuario usuario){
		return clienteRepository.obterLista(usuario.getId());
	}
	
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
		
		//mapaCliente.remove(id);
	}

}
