package br.com.fiap.exception;

public class CompetenciaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 2753033791816564656L;

	public CompetenciaNaoEncontradaException(Long id) {
		super("Competência com id " + id + " não encontrada");
	}
}
