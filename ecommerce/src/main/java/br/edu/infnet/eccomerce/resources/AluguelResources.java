package br.edu.infnet.eccomerce.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eccomerce.resources.dto.AluguelDTO;

@RestController
@RequestMapping("/alugueis")
public class AluguelResources {
	
	@PostMapping
	public void efetuarAluguel(@RequestBody AluguelDTO aluguelDTO)
	{
		System.out.println(aluguelDTO);
	}

}
