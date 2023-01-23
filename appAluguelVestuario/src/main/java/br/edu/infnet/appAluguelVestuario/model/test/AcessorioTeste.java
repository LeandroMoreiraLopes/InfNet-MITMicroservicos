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

import br.edu.infnet.appAluguelVestuario.model.domain.Acessorio;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.exceptions.DescricaoInvalidaException;
import br.edu.infnet.appAluguelVestuario.model.service.AcessorioService;

@Component
@Order(5)
public class AcessorioTeste implements ApplicationRunner{
	
	@Autowired
	private AcessorioService acessorioService;
	
	@Override
	public void run(ApplicationArguments args) throws DescricaoInvalidaException {
		System.out.println("#Inserindo Acessórios");
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		String dir = "C:/Users/llopes/Desktop/Pós MIT Eng de Software/workspace/appAluguelVestuario/appAluguelVestuario/src/main/resources/";
		String arq = "vestuarios.txt";
		
		try {
			try {
				FileReader fileReader = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(fileReader);
				
				String linha = leitura.readLine();
				while(linha!= null){
					
					String[] campos = linha.split(";");
					
					if(campos[0].equalsIgnoreCase("A"))
					{
						Acessorio a1 = new Acessorio();
						a1.setNome(campos[1]);
						a1.setValorDoAluguel(Integer.valueOf(campos[2]));
						a1.setQtdDias(Integer.valueOf(campos[3]));
						a1.setDescricao(campos[4]);
						a1.setTipo(campos[5]);
						a1.setMaterial(campos[6]);
						a1.setUsuario(usuario);
						System.out.println("Cálculo do aluguel: " + a1.calcularAluguel());
						acessorioService.incluir(a1);
					}			
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
			System.out.println("Arquivo de ACESSORIOS lido");
		}
	}
}
