package br.edu.infnet.appAluguelVestuario.model.exceptions;

public class QtdDiasInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public QtdDiasInvalidoException(String mensagem)
	{
		super(mensagem);
	}
}
