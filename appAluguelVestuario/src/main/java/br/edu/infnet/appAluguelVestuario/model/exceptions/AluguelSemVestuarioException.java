package br.edu.infnet.appAluguelVestuario.model.exceptions;

public class AluguelSemVestuarioException extends Exception {

	private static final long serialVersionUID = 1L;

	public AluguelSemVestuarioException(String mensagem){
		super(mensagem);
	}
}
