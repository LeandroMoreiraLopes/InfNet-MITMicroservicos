package br.edu.infnet.ecommerce.resources.dto;

import java.util.List;

public class AluguelResponseDTO {

	private ClienteDTO cliente;
	private List<VestuarioDTO> listaVestuarioDTO;
	
	public AluguelResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public AluguelResponseDTO(ClienteDTO cliente, List<VestuarioDTO> listaVestuarioDTO) {
		super();
		this.cliente = cliente;
		this.listaVestuarioDTO = listaVestuarioDTO;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<VestuarioDTO> getVestuarioDTO() {
		return listaVestuarioDTO;
	}

	public void setVestuarioDTO(List<VestuarioDTO> aluguelDTO) {
		this.listaVestuarioDTO = aluguelDTO;
	}
}
