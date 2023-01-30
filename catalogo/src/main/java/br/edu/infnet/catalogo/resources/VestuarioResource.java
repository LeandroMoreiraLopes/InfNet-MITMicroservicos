package br.edu.infnet.catalogo.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.catalogo.model.entities.Vestuario;
import br.edu.infnet.catalogo.model.services.VestuarioService;

@RestController
@RequestMapping("/vestuarios")
public class VestuarioResource {
	
	private Logger log = LoggerFactory.getLogger(VestuarioResource.class);
	
	@Autowired
	private VestuarioService vestuarioService;
	
	@GetMapping
	public  ResponseEntity<List<Vestuario>> getVestuarios(){
		log.info("Chamada para API de vestuarios");
		return ResponseEntity.ok(vestuarioService.getAll());
	}
}