package br.com.fiap.controller;

import br.com.fiap.dto.CompetenciaRequestDTO;
import br.com.fiap.dto.CompetenciaResponseDTO;
import br.com.fiap.service.CompetenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {

	private final CompetenciaService service;

	public CompetenciaController(CompetenciaService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<CompetenciaResponseDTO>> listarTodas() {
		return ResponseEntity.ok(service.listarTodas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompetenciaResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<CompetenciaResponseDTO> criar(@Valid @RequestBody CompetenciaRequestDTO dto) {
		CompetenciaResponseDTO criada = service.criar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(criada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CompetenciaResponseDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody CompetenciaRequestDTO dto) {
		return ResponseEntity.ok(service.atualizar(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}