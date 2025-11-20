package br.com.fiap.service.impl;

import br.com.fiap.dto.CompetenciaResponseDTO;
import br.com.fiap.dto.TrilhaRequestDTO;
import br.com.fiap.dto.TrilhaResponseDTO;
import br.com.fiap.exception.CompetenciaNaoEncontradaException;
import br.com.fiap.exception.TrilhaNaoEncontradaException;
import br.com.fiap.model.Competencia;
import br.com.fiap.model.Trilha;
import br.com.fiap.repository.CompetenciaRepository;
import br.com.fiap.repository.TrilhaRepository;
import br.com.fiap.service.TrilhaService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrilhaServiceImpl implements TrilhaService {

	private final TrilhaRepository trilhaRepository;
	private final CompetenciaRepository competenciaRepository;

	public TrilhaServiceImpl(TrilhaRepository trilhaRepository, CompetenciaRepository competenciaRepository) {
		this.trilhaRepository = trilhaRepository;
		this.competenciaRepository = competenciaRepository;
	}

	@Override
	public List<TrilhaResponseDTO> listarTodas() {
		return trilhaRepository.findAll().stream().map(this::toResponse).toList();
	}

	@Override
	public TrilhaResponseDTO buscarPorId(Long id) {
		Trilha trilha = trilhaRepository.findById(id).orElseThrow(() -> new TrilhaNaoEncontradaException(id));
		return toResponse(trilha);
	}

	@Override
	public TrilhaResponseDTO criar(TrilhaRequestDTO dto) {
		Trilha t = new Trilha();
		preencherTrilha(t, dto);
		t = trilhaRepository.save(t);
		return toResponse(t);
	}

	@Override
	public TrilhaResponseDTO atualizar(Long id, TrilhaRequestDTO dto) {
		Trilha t = trilhaRepository.findById(id).orElseThrow(() -> new TrilhaNaoEncontradaException(id));
		preencherTrilha(t, dto);
		t = trilhaRepository.save(t);
		return toResponse(t);
	}

	@Override
	public void deletar(Long id) {
		if (!trilhaRepository.existsById(id)) {
			throw new TrilhaNaoEncontradaException(id);
		}
		trilhaRepository.deleteById(id);
	}

	private void preencherTrilha(Trilha t, TrilhaRequestDTO dto) {
		t.setNome(dto.getNome());
		t.setDescricao(dto.getDescricao());
		t.setNivel(dto.getNivel());
		t.setCargaHoraria(dto.getCargaHoraria());
		t.setFocoPrincipal(dto.getFocoPrincipal());

		Set<Competencia> competencias = new HashSet<>();
		if (dto.getCompetenciasIds() != null) {
			for (Long idComp : dto.getCompetenciasIds()) {
				Competencia c = competenciaRepository.findById(idComp)
						.orElseThrow(() -> new CompetenciaNaoEncontradaException(idComp));
				competencias.add(c);
			}
		}
		t.setCompetencias(competencias);
	}

	private TrilhaResponseDTO toResponse(Trilha t) {
		TrilhaResponseDTO dto = new TrilhaResponseDTO();
		dto.setId(t.getId());
		dto.setNome(t.getNome());
		dto.setDescricao(t.getDescricao());
		dto.setNivel(t.getNivel());
		dto.setCargaHoraria(t.getCargaHoraria());
		dto.setFocoPrincipal(t.getFocoPrincipal());

		List<CompetenciaResponseDTO> competencias = t.getCompetencias().stream()
				.map(c -> new CompetenciaResponseDTO(c.getId(), c.getNome(), c.getCategoria(), c.getDescricao()))
				.toList();

		dto.setCompetencias(competencias);
		return dto;
	}
}
