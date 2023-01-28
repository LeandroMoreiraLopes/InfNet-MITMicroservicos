package br.edu.infnet.ecommerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.ecommerce.resources.dto.AluguelDTO;
import br.edu.infnet.ecommerce.resources.dto.ClienteDTO;

@RestController
@RequestMapping("/alugueis")
public class AluguelResources {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${cliente.endpoint.url}")
	private String clienteApiUrl;
	
	@PostMapping
	public void efetuarAluguel(@RequestBody AluguelDTO aluguelDTO)
	{
		ClienteDTO clienteDTO = restTemplate.getForObject(clienteApiUrl +
								aluguelDTO.getClienteId(), ClienteDTO.class);
		
		System.out.println(clienteDTO);
		System.out.println(aluguelDTO);
	}

}
