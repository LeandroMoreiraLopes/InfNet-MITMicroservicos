package br.edu.infnet.appAluguelVestuario.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appAluguelVestuario.model.exceptions.DescricaoInvalidaException;

@Entity
@Table(name = "TAcessorio")
public class Acessorio extends Vestuario{
	private String descricao;
	private String tipo;
	private String material;

	@Override
	public double calcularAluguel() throws DescricaoInvalidaException {

		if (descricao == null) {
			throw new DescricaoInvalidaException("Impossivel calcular valor de acessório com descrição nula");
		}

		else if (descricao.isEmpty())
		{
			throw new DescricaoInvalidaException("Impossivel calcular valor de acessório sem descrição");
		}

		return getValorDoAluguel() * getQtdDias();
	}

	@Override
	public String toString() {
		return descricao + ";" + tipo + ";" + material + ";" + super.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void impressao() {
		System.out.println("#Acessorio");
		System.out.println(this);
	}
}