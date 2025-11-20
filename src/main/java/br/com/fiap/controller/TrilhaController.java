package br.com.fiap.controller;

import br.com.fiap.dto.TrilhaRequestDTO;
import br.com.fiap.dto.TrilhaResponseDTO;
import br.com.fiap.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

	private final TrilhaService service;

	public TrilhaController(TrilhaService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<TrilhaResponseDTO>> listarTodas() {
		return ResponseEntity.ok(service.listarTodas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TrilhaResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<TrilhaResponseDTO> criar(@Valid @RequestBody TrilhaRequestDTO dto) {
		TrilhaResponseDTO criada = service.criar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(criada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TrilhaResponseDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody TrilhaRequestDTO dto) {
		return ResponseEntity.ok(service.atualizar(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
