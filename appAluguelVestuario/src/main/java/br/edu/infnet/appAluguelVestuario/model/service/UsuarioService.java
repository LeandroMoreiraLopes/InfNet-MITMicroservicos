package br.edu.infnet.appAluguelVestuario.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static Map<String, Usuario> mapaUsuario = new HashMap<String, Usuario>();
	
	public Usuario validar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email); 
		
		if (usuario != null && senha.equalsIgnoreCase(usuario.getSenha())){
			return usuario;
		}		
		return null; 
	}
	
	public void incluir(Usuario usuario)	{
		usuarioRepository.save(usuario);
		
		mapaUsuario.put(usuario.getEmail(), usuario);
		
		//AppImpressao.relatorio("Inclusão do usuário " + usuario.getNome() + " realizada com sucesso", usuario);
	}
	
	public void excluir(String email) {
		mapaUsuario.remove(email);
	}
	
	public Collection<Usuario> obterLista(){
		return mapaUsuario.values();
	}
}
