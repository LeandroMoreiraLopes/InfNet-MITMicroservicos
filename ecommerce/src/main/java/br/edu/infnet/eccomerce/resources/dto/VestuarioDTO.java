package br.edu.infnet.eccomerce.resources.dto;

public class VestuarioDTO {

	private Integer id;
	private String nome;
	private double valorDoAluguel;
	private int qtdDias;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorDoAluguel() {
		return valorDoAluguel;
	}
	public void setValorDoAluguel(double valorDoAluguel) {
		this.valorDoAluguel = valorDoAluguel;
	}
	public int getQtdDias() {
		return qtdDias;
	}
	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	@Override
	public String toString() {
		return "VestuarioDTO [id=" + id + ", nome=" + nome + ", valorDoAluguel=" + valorDoAluguel + ", qtdDias="
				+ qtdDias + "]";
	}
}
