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

import br.edu.infnet.appAluguelVestuario.model.domain.Roupa;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.exceptions.QtdDiasInvalidoException;
import br.edu.infnet.appAluguelVestuario.model.service.RoupaService;

@Component
@Order(3)
public class RoupaTeste implements ApplicationRunner {

	@Autowired
	private RoupaService roupaService;
	
	@Override
	public void run(ApplicationArguments args) throws QtdDiasInvalidoException {
		System.out.println("#Inserindo Roupas");

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
							
					if(campos[0].equalsIgnoreCase("R"))
					{
						Roupa r1 = new Roupa();
						r1.setNome(campos[1]);
						r1.setValorDoAluguel(Integer.valueOf(campos[2]));
						r1.setQtdDias(Integer.valueOf(campos[3]));
						r1.setTamanho(campos[4]);
						r1.setTipoDeTecido(campos[5]);
						r1.setParaNoite(Boolean.valueOf(campos[6]));
						r1.setUsuario(usuario);
						System.out.println("Cálculo de aluguel: " + r1.calcularAluguel());
						roupaService.incluir(r1);
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
			System.out.println("Arquivo de ROUPAS lido");
		}
	}
}
