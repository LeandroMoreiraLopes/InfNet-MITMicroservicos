package br.edu.infnet.appAluguelVestuario.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioTeste implements ApplicationRunner{

	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		usuario = new Usuario();
		usuario.setEmail("admin@admin.com");
		usuario.setNome("Administrador");
		usuario.setSenha("123");
		
		//UsuarioService usuarioService = new UsuarioService();
		//usuarioService.incluir(usuario);
		
		//new UsuarioService().incluir(usuario);
		
		usuarioService.incluir(usuario);
		
		String dir = "C:/Users/llopes/Desktop/Pós MIT Eng de Software/workspace/appAluguelVestuario/appAluguelVestuario/src/main/resources/";
		String arq = "usuarios.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha!= null){
					
					String[] campos = linha.split(";");
											
					usuario = new Usuario();
					usuario.setNome(campos[0]);
					usuario.setEmail(campos[1]);
					usuario.setSenha(campos[2]);
					
					usuarioService.incluir(usuario);
									
					linha = leitura.readLine();
				}
				
				leitura.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("[ERRO] O arquivo não existe");
			} catch (IOException e) {
				System.out.println("[ERRO] Problema no fechamento do arquivo");
			}
			
		} finally {
			System.out.println("Arquivo de USUARIOS lido");
		}
	}
}
