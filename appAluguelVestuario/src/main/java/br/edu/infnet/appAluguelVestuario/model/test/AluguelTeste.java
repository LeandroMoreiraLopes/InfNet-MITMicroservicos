package br.edu.infnet.appAluguelVestuario.model.test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appAluguelVestuario.model.domain.Aluguel;
import br.edu.infnet.appAluguelVestuario.model.domain.Cliente;
import br.edu.infnet.appAluguelVestuario.model.domain.Roupa;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.domain.Vestuario;
import br.edu.infnet.appAluguelVestuario.model.exceptions.AluguelSemVestuarioException;
import br.edu.infnet.appAluguelVestuario.model.exceptions.ClienteNuloException;
import br.edu.infnet.appAluguelVestuario.model.service.AluguelService;
import br.edu.infnet.appAluguelVestuario.model.service.RoupaService;

@Component
@Order(6)
public class AluguelTeste implements ApplicationRunner{
		
	@Autowired
	private AluguelService aluguelService;
	
	@Autowired
	private RoupaService roupaService;
	
	@Override
	public void run(ApplicationArguments args) {
		System.out.println("#Inserindo Alugueis");
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1);
			
			Cliente cliente = new Cliente();
			cliente.setId(1);
			
			Set<Vestuario> vestuarios = new HashSet<Vestuario>();
			
			vestuarios.addAll(roupaService.loadRoupas(1));
			vestuarios.addAll(roupaService.loadRoupas(2));
			vestuarios.addAll(roupaService.loadRoupas(3));		
			
			Aluguel aluguel = new Aluguel(cliente, vestuarios);
			aluguel.setItemAlugado("Teste");
			aluguel.setDataEvento(LocalDateTime.now());
			aluguel.setValorTotal(2000);
			aluguel.setUsuario(usuario);
			
			aluguelService.incluir(aluguel);
		} 
		
		catch (ClienteNuloException | AluguelSemVestuarioException e) {
			e.printStackTrace();
		}
		
		
				
		
		
		
		
		
		
//		Roupa r1 = new Roupa();
//		r1.setNome("Paletó Summer");
//		r1.setValorDoAluguel(1600);
//		r1.setQtdDias(2);
//		r1.setTamanho("G");
//		r1.setTipoDeTecido("Poliéster");
//		r1.setParaNoite(false);
//		Calcado ca1 = new Calcado();
//		ca1.setNome("Mocassino");
//		ca1.setValorDoAluguel(100.0);
//		ca1.setQtdDias(1);
//		ca1.setTamanho(38);
//		ca1.setTipoDeSalto("Baixo");
//		ca1.setCor("Preto");
//		Acessorio ac1 = new Acessorio();
//		ac1.setNome("Gucci N");
//		ac1.setValorDoAluguel(30.0);
//		ac1.setQtdDias(3);
//		ac1.setDescricao("VX 1300");
//		ac1.setTipo("Colar");
//		ac1.setMaterial("Prata com brilhantes");
//		Acessorio ac2 = new Acessorio();
//		ac2.setNome("Gucci N");
//		ac2.setValorDoAluguel(30.0);
//		ac2.setQtdDias(3);
//		ac2.setDescricao("VX 1300");
//		ac2.setTipo("Colar");
//		ac2.setMaterial("Prata com brilhantes");
		
		//--------------------------
		
//		String dir = "C:/Users/llopes/Desktop/Pós MIT Eng de Software/workspace/appAluguelVestuario/appAluguelVestuario/src/main/resources/";
//		String arq = "alugueis.txt";
//		
//		try {
//			try {
//				FileReader fileReader = new FileReader(dir+arq);
//				BufferedReader leitura = new BufferedReader(fileReader);
//				
//				Set<Vestuario> vestuarios = null;
//				List<Aluguel> alugueis = new ArrayList<Aluguel>();
//				
//				String linha = leitura.readLine();
//				while(linha!= null)
//				{
//					String[] campos = linha.split(";");
//					
//					switch (campos[0].toUpperCase()) {
//					case "AA":
//						try {
//						String[] dataEvento = campos[4].split("/");
//						String[] dataNasc = campos[7].split("/");
//						
//						vestuarios = new HashSet<Vestuario>();
//						
//						Cliente c1 = new Cliente(campos[5], campos[6], LocalDateTime.of(Integer.parseInt(dataNasc[0]), 
//																							Integer.parseInt(dataNasc[1]),
//																							Integer.parseInt(dataNasc[2]),
//																							0, 0));
//						
//						Aluguel aluguel = new Aluguel(c1, vestuarios);
//						aluguel.setItemAlugado(campos[2]);
//						aluguel.setValorTotal(Double.parseDouble(campos[3]));
//						aluguel.setDataEvento(LocalDateTime.of(Integer.parseInt(dataEvento[0]), 
//															Integer.parseInt(dataEvento[1]),
//															Integer.parseInt(dataEvento[2]),
//															19, 0));
//						alugueis.add(aluguel);
//					} catch (CpfInvalidoException | ClienteNuloException | AluguelSemVestuarioException e) {
//						System.out.println("[ERROR - ALUGUEL] " + e.getMessage());
//					}
//						break;
//					case "R":
//						Roupa r1 = new Roupa();
//						r1.setNome(campos[1]);
//						r1.setValorDoAluguel(Integer.valueOf(campos[2]));
//						r1.setQtdDias(Integer.valueOf(campos[3]));
//						r1.setTamanho(campos[4]);
//						r1.setTipoDeTecido(campos[5]);
//						r1.setParaNoite(Boolean.valueOf(campos[6]));
//						roupaService.incluir(r1);
//						
//						vestuarios.add(r1);
//						break;
//					case "C":
//						Calcado c1 = new Calcado();
//						c1.setNome(campos[1]);
//						c1.setValorDoAluguel(Integer.valueOf(campos[2]));
//						c1.setQtdDias(Integer.valueOf(campos[3]));
//						c1.setTamanho(Integer.valueOf(campos[4]));
//						c1.setTipoDeSalto(campos[5]);
//						c1.setCor(campos[6]);
//						calcadoService.incluir(c1);
//						
//						vestuarios.add(c1);
//						break;
//					case "A":
//						Acessorio a1 = new Acessorio();
//						a1.setNome(campos[1]);
//						a1.setValorDoAluguel(Integer.valueOf(campos[2]));
//						a1.setQtdDias(Integer.valueOf(campos[3]));
//						a1.setDescricao(campos[4]);
//						a1.setTipo(campos[5]);
//						a1.setMaterial(campos[6]);
//						acessorioService.incluir(a1);
//						
//						vestuarios.add(a1);
//						break;
//
//					default:
//						break;
//					}
//
//					linha = leitura.readLine();
//				}
//				
//				for (Aluguel a: alugueis) {
//					aluguelService.incluir(a);	
//					System.out.println(">>>>>>>>> " + a.getId());
//					System.out.println(">>>>>>>> " + a.getCliente().getNome());
//					System.out.println(">>>>>>> " + a.getListaVestuario().size());				
//				}
//								
//				leitura.close();
//				fileReader.close();
//			} catch (FileNotFoundException e) {
//				System.out.println("[ERRO] O arquivo não existe");
//			} catch (IOException e) {
//				System.out.println("[ERRO] Problema no fechamento do arquivo");
//			}
//			
//		} finally {
//			System.out.println("Arquivo lido");
//		}
	}
}
