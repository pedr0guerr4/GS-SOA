package br.com.fiap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroResponse> handleValidation(MethodArgumentNotValidException ex) {
		List<String> mensagens = ex.getBindingResult().getFieldErrors().stream()
				.map(err -> err.getField() + ": " + err.getDefaultMessage()).toList();

		ErroResponse erro = new ErroResponse(HttpStatus.BAD_REQUEST.value(), "VALIDATION_ERROR",
				String.join("; ", mensagens), LocalDateTime.now());

		return ResponseEntity.badRequest().body(erro);
	}

	@ExceptionHandler(CompetenciaNaoEncontradaException.class)
	public ResponseEntity<ErroResponse> handleCompetenciaNotFound(CompetenciaNaoEncontradaException ex) {
		ErroResponse erro = new ErroResponse(HttpStatus.NOT_FOUND.value(), "NOT_FOUND", ex.getMessage(),
				LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(TrilhaNaoEncontradaException.class)
	public ResponseEntity<ErroResponse> handleTrilhaNotFound(TrilhaNaoEncontradaException ex) {
		ErroResponse erro = new ErroResponse(HttpStatus.NOT_FOUND.value(), "NOT_FOUND", ex.getMessage(),
				LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroResponse> handleGeneric(Exception ex) {
		ErroResponse erro = new ErroResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL_ERROR",
				ex.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}
}
