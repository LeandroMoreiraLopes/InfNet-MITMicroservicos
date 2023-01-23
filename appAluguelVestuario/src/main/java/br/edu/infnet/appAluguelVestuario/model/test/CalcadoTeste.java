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

import br.edu.infnet.appAluguelVestuario.model.domain.Calcado;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.exceptions.TamanhoInvalidoException;
import br.edu.infnet.appAluguelVestuario.model.service.CalcadoService;

@Component
@Order(4)
public class CalcadoTeste implements ApplicationRunner {
	
	@Autowired
	private CalcadoService calcadoService;
	
	@Override
	public void run(ApplicationArguments args) throws TamanhoInvalidoException {
		System.out.println("#Inserindo Calçados");

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
					
					if(campos[0].equalsIgnoreCase("C"))
					{
						Calcado c1 = new Calcado();
						c1.setNome(campos[1]);
						c1.setValorDoAluguel(Integer.valueOf(campos[2]));
						c1.setQtdDias(Integer.valueOf(campos[3]));
						c1.setTamanho(Integer.valueOf(campos[4]));
						c1.setTipoDeSalto(campos[5]);
						c1.setCor(campos[6]);
						c1.setUsuario(usuario);
						System.out.println("Cálculo de aluguel: " + c1.calcularAluguel());
						calcadoService.incluir(c1);
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
			System.out.println("Arquivo de CALCADOS lido");
		}
	}
}
