package br.edu.infnet.appAluguelVestuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appAluguelVestuario.model.domain.Calcado;
import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.service.CalcadoService;

@Controller
public class CalcadoController {
	
	@Autowired
	private CalcadoService calcadoService;
	
	@GetMapping(value = "/calcado/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", calcadoService.obterLista(usuario));
		
		return "calcado/lista";
	}
	
	@GetMapping(value = "/calcado")
	public String telaCadastro(){
		
		return "calcado/cadastro";
	}
	
	@PostMapping(value = "/calcado/incluir")
	public String incluir(Calcado calcado, @SessionAttribute("user") Usuario usuario){
		
		calcado.setUsuario(usuario);
		
		calcadoService.incluir(calcado);
		
		return "redirect:/calcado/lista";
	}
	
	@GetMapping(value = "/calcado/{id}/excluir")
	public String excluir(@PathVariable Integer id){
		try {
			calcadoService.excluir(id);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
				
		return "redirect:/calcado/lista";
	}
}
