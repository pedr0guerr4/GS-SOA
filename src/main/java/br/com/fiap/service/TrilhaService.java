package br.com.fiap.service;

import br.com.fiap.dto.TrilhaRequestDTO;
import br.com.fiap.dto.TrilhaResponseDTO;

import java.util.List;

public interface TrilhaService {

	List<TrilhaResponseDTO> listarTodas();

	TrilhaResponseDTO buscarPorId(Long id);

	TrilhaResponseDTO criar(TrilhaRequestDTO dto);

	TrilhaResponseDTO atualizar(Long id, TrilhaRequestDTO dto);

	void deletar(Long id);
}