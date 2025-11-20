package br.com.fiap.dto;

import br.com.fiap.enums.NivelTrilha;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TrilhaRequestDTO {

	@NotBlank(message = "nome é obrigatório")
	@Size(max = 150, message = "nome deve ter no máximo 150 caracteres")
	private String nome;

	private String descricao;

	@NotNull(message = "nivel é obrigatório")
	private NivelTrilha nivel;

	@NotNull(message = "cargaHoraria é obrigatória")
	@Min(value = 1, message = "cargaHoraria deve ser maior que zero")
	private Integer cargaHoraria;

	@Size(max = 100, message = "focoPrincipal deve ter no máximo 100 caracteres")
	private String focoPrincipal;

	private List<Long> competenciasIds;

	public TrilhaRequestDTO() {
	}

	public TrilhaRequestDTO(String nome, String descricao, NivelTrilha nivel, Integer cargaHoraria,
			String focoPrincipal, List<Long> competenciasIds) {
		this.nome = nome;
		this.descricao = descricao;
		this.nivel = nivel;
		this.cargaHoraria = cargaHoraria;
		this.focoPrincipal = focoPrincipal;
		this.competenciasIds = competenciasIds;
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

	public List<Long> getCompetenciasIds() {
		return competenciasIds;
	}

	public void setCompetenciasIds(List<Long> competenciasIds) {
		this.competenciasIds = competenciasIds;
	}
}
