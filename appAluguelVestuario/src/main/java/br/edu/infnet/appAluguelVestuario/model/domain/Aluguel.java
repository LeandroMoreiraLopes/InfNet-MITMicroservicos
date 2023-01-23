package br.edu.infnet.appAluguelVestuario.model.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.appAluguelVestuario.interfaces.IPrinter;
import br.edu.infnet.appAluguelVestuario.model.exceptions.AluguelSemVestuarioException;
import br.edu.infnet.appAluguelVestuario.model.exceptions.ClienteNuloException;

@Entity
@Table(name = "TAluguel")
public class Aluguel implements IPrinter{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String itemAlugado;
	private double valorTotal;
	private LocalDateTime dataEvento;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private Set<Vestuario> listaVestuario;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public Aluguel() {
		dataEvento = LocalDateTime.now();
	}

	public Aluguel(Cliente cliente, Set<Vestuario> listaVestuario) throws ClienteNuloException, AluguelSemVestuarioException{
		this();
		
		if (cliente == null) {
			throw new ClienteNuloException("Impossível criar um aluguel sem cliente");
		}

//		if (listaVestuario == null) {
//			throw new AluguelSemVestuarioException("Impossível criar um aluguel com vestuário nulo");
//		}
//
//		else if (listaVestuario.size() <= 0) {
//			throw new AluguelSemVestuarioException("Impossível criar um aluguel sem vestuários");
//		}

		this.cliente  = cliente;
		this.listaVestuario = listaVestuario;
	}

	@Override
	public void impressao() {
		System.out.println("#Aluguel");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return itemAlugado + ";" + valorTotal + ";" + dataEvento + ";" + cliente + ";" + listaVestuario.size();
	}

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

	public LocalDateTime getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDateTime dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Set<Vestuario> getListaVestuario() {
		return listaVestuario;
	}

	public void setListaVestuario(Set<Vestuario> listaVestuario) {
		this.listaVestuario = listaVestuario;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
