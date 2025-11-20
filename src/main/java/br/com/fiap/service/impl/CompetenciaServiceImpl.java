package br.com.fiap.service.impl;

import br.com.fiap.dto.CompetenciaRequestDTO;
import br.com.fiap.dto.CompetenciaResponseDTO;
import br.com.fiap.exception.CompetenciaNaoEncontradaException;
import br.com.fiap.model.Competencia;
import br.com.fiap.repository.CompetenciaRepository;
import br.com.fiap.service.CompetenciaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaServiceImpl implements CompetenciaService {

	private final CompetenciaRepository repository;

	public CompetenciaServiceImpl(CompetenciaRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<CompetenciaResponseDTO> listarTodas() {
		return repository.findAll().stream().map(this::toResponse).toList();
	}

	@Override
	public CompetenciaResponseDTO buscarPorId(Long id) {
		Competencia competencia = repository.findById(id).orElseThrow(() -> new CompetenciaNaoEncontradaException(id));
		return toResponse(competencia);
	}

	@Override
	public CompetenciaResponseDTO criar(CompetenciaRequestDTO dto) {
		Competencia c = new Competencia();
		c.setNome(dto.getNome());
		c.setCategoria(dto.getCategoria());
		c.setDescricao(dto.getDescricao());
		c = repository.save(c);
		return toResponse(c);
	}

	@Override
	public CompetenciaResponseDTO atualizar(Long id, CompetenciaRequestDTO dto) {
		Competencia c = repository.findById(id).orElseThrow(() -> new CompetenciaNaoEncontradaException(id));
		c.setNome(dto.getNome());
		c.setCategoria(dto.getCategoria());
		c.setDescricao(dto.getDescricao());
		c = repository.save(c);
		return toResponse(c);
	}

	@Override
	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new CompetenciaNaoEncontradaException(id);
		}
		repository.deleteById(id);
	}

	private CompetenciaResponseDTO toResponse(Competencia c) {
		CompetenciaResponseDTO dto = new CompetenciaResponseDTO();
		dto.setId(c.getId());
		dto.setNome(c.getNome());
		dto.setCategoria(c.getCategoria());
		dto.setDescricao(c.getDescricao());
		return dto;
	}
}