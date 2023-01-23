package br.edu.infnet.appAluguelVestuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appAluguelVestuario.model.domain.Usuario;
import br.edu.infnet.appAluguelVestuario.model.service.VestuarioService;

@Controller
public class VestuarioController {
	
	@Autowired
	private VestuarioService vestuarioService; 
	
	@GetMapping(value = "/vestuario/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
					
		model.addAttribute("listagem", vestuarioService.obterLista(usuario));
		
		return "vestuario/lista";
	}
	
	@GetMapping(value = "/vestuario/{id}/excluir")
	public String excluir(@PathVariable Integer id){
		try {
			vestuarioService.excluir(id);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
			
		return "redirect:/vestuario/lista";
	}

}
