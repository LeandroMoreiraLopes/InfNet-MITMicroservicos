package br.edu.infnet.appAluguelVestuario.model.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAluguelVestuario.model.domain.Cliente;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.exceptions.CpfInvalidoException;
import br.edu.infnet.appAluguelVestuario.model.service.ClienteService;

@Component
@Order(2)
public class ClienteTeste implements ApplicationRunner{

	@Autowired
	private ClienteService clienteService;
	
	private Cliente cliente;
	
	@Override
	public void run(ApplicationArguments args) throws NumberFormatException, CpfInvalidoException {
		System.out.println("#Inserindo Clientes");
		
		String dir = "C:/Users/llopes/Desktop/Pós MIT Eng de Software/workspace/appAluguelVestuario/appAluguelVestuario/src/main/resources/";
		String arq = "clientes.txt";
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setEmail("admin@admin.com");
		usuario.setNome("Administrador");
		usuario.setSenha("123");
		
		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha!= null){
					
					String[] campos = linha.split(";");
					String[] data = campos[2].split("-");
											
					cliente = new Cliente(campos[0],
											campos[1],
											LocalDateTime.of(Integer.parseInt(data[2]),
															Integer.parseInt(data[1]),
															Integer.parseInt(data[0]),
															0, 0));

					cliente.setUsuario(usuario);
					clienteService.incluir(cliente);
									
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
			System.out.println("Arquivo de CLIENTES lido");
		}
	}	
}
