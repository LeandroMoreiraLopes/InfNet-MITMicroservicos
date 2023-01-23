package br.edu.infnet.appAluguelVestuario.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.infnet.appAluguelVestuario.interfaces.IPrinter;

@Entity
@Table(name = "tusuario")
public class Usuario implements IPrinter{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String senha;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Cliente> clientes;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Vestuario> vestuarios;
	@OneToMany
	@JoinColumn(name = "idUsuario")
	private List<Aluguel> alugueis;

	@Override
	public void impressao() {
		System.out.println("#Usuario");
		System.out.println(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nome + ";" + email + ";" + senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Vestuario> getVestuarios() {
		return vestuarios;
	}

	public void setVestuarios(List<Vestuario> vestuarios) {
		this.vestuarios = vestuarios;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
}
