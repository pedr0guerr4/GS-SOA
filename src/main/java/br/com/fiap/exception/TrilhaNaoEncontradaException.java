package br.com.fiap.exception;

public class TrilhaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = -1576797782719705457L;

	public TrilhaNaoEncontradaException(Long id) {
		super("Trilha com id " + id + " não encontrada");
	}
}
