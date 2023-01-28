package br.edu.infnet.ecommerce.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.ecommerce.resources.dto.VestuarioDTO;

@FeignClient("vestuario")
public interface VestuarioClient {

	@RequestMapping("/vestuarios")
	public  List<VestuarioDTO> getVestuarios();
	
}
