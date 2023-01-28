package br.edu.infnet.ecommerce.resources.dto;

import java.util.List;

public class AluguelDTO {
		
	private String itemAlugado;
	
	private double valorTotal;
	
	private Integer clienteId;
	
	private List<VestuarioDTO>vestuarios;

	public String getItemAlugado() {
		return itemAlugado;
	}

	public void setItemAlugado(String itemAlugado) {
		this.itemAlugado = itemAlugado;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public List<VestuarioDTO> getVestuarios() {
		return vestuarios;
	}

	public void setVestuarios(List<VestuarioDTO> vestuarios) {
		this.vestuarios = vestuarios;
	}

	@Override
	public String toString() {
		return "AluguelDTO [itemAlugado=" + itemAlugado + ", valorTotal=" + valorTotal
				+ ", clienteId=" + clienteId + ", vestuarios=" + vestuarios + "]";
	}
}
