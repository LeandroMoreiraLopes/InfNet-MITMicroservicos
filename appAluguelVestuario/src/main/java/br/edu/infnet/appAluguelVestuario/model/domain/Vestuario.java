package br.edu.infnet.appAluguelVestuario.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.appAluguelVestuario.interfaces.IPrinter;
import br.edu.infnet.appAluguelVestuario.model.exceptions.DescricaoInvalidaException;
import br.edu.infnet.appAluguelVestuario.model.exceptions.QtdDiasInvalidoException;
import br.edu.infnet.appAluguelVestuario.model.exceptions.TamanhoInvalidoException;

@Entity
@Table(name = "TVestuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vestuario implements IPrinter{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private double valorDoAluguel;
	private int qtdDias;
	@ManyToMany(mappedBy = "listaVestuario")
	private List<Aluguel> alugueis;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public abstract double calcularAluguel() throws QtdDiasInvalidoException, TamanhoInvalidoException, DescricaoInvalidaException;

/*	public double calcularAluguel()
	{
		return valorDoAluguel * qtdDias;
	}*/

	@Override
	public String toString() {
		return nome + ";" + valorDoAluguel + ";" + qtdDias;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Vestuario other = (Vestuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
