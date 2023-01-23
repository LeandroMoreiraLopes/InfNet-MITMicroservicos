package br.edu.infnet.appAluguelVestuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appAluguelVestuario.model.domain.Acessorio;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.service.AcessorioService;

@Controller
public class AcessorioController {
	
	@Autowired
	private AcessorioService acessorioService;
	
	@GetMapping(value = "/acessorio/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", acessorioService.obterLista(usuario));
		
		return "acessorio/lista";
	}
	
	@GetMapping(value = "/acessorio")
	public String telaCadastro(){
		
		return "acessorio/cadastro";
	}
	
	@PostMapping(value = "/acessorio/incluir")
	public String incluir(Acessorio acessorio, @SessionAttribute("user") Usuario usuario){
		
		acessorio.setUsuario(usuario);
		
		acessorioService.incluir(acessorio);
		
		return "redirect:/acessorio/lista";
	}
	
	@GetMapping(value = "/acessorio/{id}/excluir")
	public String excluir(@PathVariable Integer id){
		
		try {
			acessorioService.excluir(id);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
			
		return "redirect:/acessorio/lista";
	}
}
