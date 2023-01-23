package br.edu.infnet.appAluguelVestuario.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appAluguelVestuario.model.exceptions.QtdDiasInvalidoException;

@Entity
@Table(name = "TRoupa")
public class Roupa extends Vestuario{
	private String tamanho;
	private String tipoDeTecido;
	private boolean paraNoite;

	@Override
	public double calcularAluguel() throws QtdDiasInvalidoException {

		if (getQtdDias() <= 0){
			throw new QtdDiasInvalidoException("Impossível calcular com a quantidade de dias ("+getQtdDias()+") com valor menor ou igual a zero");
		}

		double multiplicador = paraNoite ? 1.3d : 1d;
		return getValorDoAluguel() * getQtdDias() * multiplicador;
	}

	@Override
	public String toString() {
		return tamanho + ";" + tipoDeTecido + ";" + paraNoite + ";" + super.toString();
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipoDeTecido() {
		return tipoDeTecido;
	}

	public void setTipoDeTecido(String tipoDeTecido) {
		this.tipoDeTecido = tipoDeTecido;
	}

	public boolean isParaNoite() {
		return paraNoite;
	}

	public void setParaNoite(boolean paraNoite) {
		this.paraNoite = paraNoite;
	}

	@Override
	public void impressao() {
		System.out.println("#Roupa");
		System.out.println(this);
	}
}
