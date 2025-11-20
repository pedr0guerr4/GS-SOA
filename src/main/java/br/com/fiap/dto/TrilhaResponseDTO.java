package br.com.fiap.dto;

import br.com.fiap.enums.NivelTrilha;

import java.util.List;

public class TrilhaResponseDTO {

	private Long id;
	private String nome;
	private String descricao;
	private NivelTrilha nivel;
	private Integer cargaHoraria;
	private String focoPrincipal;
	private List<CompetenciaResponseDTO> competencias;

	public TrilhaResponseDTO() {
	}

	public TrilhaResponseDTO(Long id, String nome, String descricao, NivelTrilha nivel, Integer cargaHoraria,
			String focoPrincipal, List<CompetenciaResponseDTO> competencias) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.nivel = nivel;
		this.cargaHoraria = cargaHoraria;
		this.focoPrincipal = focoPrincipal;
		this.competencias = competencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public NivelTrilha getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrilha nivel) {
		this.nivel = nivel;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getFocoPrincipal() {
		return focoPrincipal;
	}

	public void setFocoPrincipal(String focoPrincipal) {
		this.focoPrincipal = focoPrincipal;
	}

	public List<CompetenciaResponseDTO> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompetenciaResponseDTO> competencias) {
		this.competencias = competencias;
	}
}
