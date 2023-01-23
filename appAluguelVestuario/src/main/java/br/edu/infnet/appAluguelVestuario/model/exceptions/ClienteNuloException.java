package br.edu.infnet.appAluguelVestuario.model.exceptions;

public class ClienteNuloException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClienteNuloException(String mensagem){
		super(mensagem);
	}
}
