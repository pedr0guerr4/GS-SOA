package br.com.fiap.service;

import br.com.fiap.dto.CompetenciaRequestDTO;
import br.com.fiap.dto.CompetenciaResponseDTO;

import java.util.List;

public interface CompetenciaService {

	List<CompetenciaResponseDTO> listarTodas();

	CompetenciaResponseDTO buscarPorId(Long id);

	CompetenciaResponseDTO criar(CompetenciaRequestDTO dto);

	CompetenciaResponseDTO atualizar(Long id, CompetenciaRequestDTO dto);

	void deletar(Long id);
}
