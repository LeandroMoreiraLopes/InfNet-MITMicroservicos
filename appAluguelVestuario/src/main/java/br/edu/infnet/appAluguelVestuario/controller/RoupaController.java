package br.edu.infnet.appAluguelVestuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appAluguelVestuario.model.domain.Roupa;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.service.RoupaService;

@Controller
public class RoupaController {
	
	@Autowired
	private RoupaService roupaService;
	
	@GetMapping(value = "/roupa/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
					
		model.addAttribute("listagem", roupaService.obterLista(usuario));
		
		return "roupa/lista";
	}

	@GetMapping(value = "/roupa")
	public String telaCadastro(){
		
		return "roupa/cadastro";
	}
	
	@PostMapping(value = "/roupa/incluir")
	public String incluir(Roupa roupa, @SessionAttribute("user") Usuario usuario){
		
		roupa.setUsuario(usuario);
		
		roupaService.incluir(roupa);
		
		return "redirect:/roupa/lista";
	}
	
	@GetMapping(value = "/roupa/{id}/excluir")
	public String excluir(@PathVariable Integer id){
		try {
			roupaService.excluir(id);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
			
		return "redirect:/roupa/lista";
	}
}
