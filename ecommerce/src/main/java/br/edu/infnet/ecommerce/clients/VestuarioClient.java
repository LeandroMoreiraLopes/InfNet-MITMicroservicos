package br.edu.infnet.ecommerce.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.ecommerce.resources.dto.VestuarioDTO;

@FeignClient("vestuario")
public interface VestuarioClient {

	@RequestMapping(value = "/vestuarios", method = RequestMethod.GET)
	public  ResponseEntity<List<VestuarioDTO>> getVestuarios();
	
}
