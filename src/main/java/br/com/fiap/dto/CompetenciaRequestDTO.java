package br.com.fiap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CompetenciaRequestDTO {

	@NotBlank(message = "nome é obrigatório")
	@Size(max = 100, message = "nome deve ter no máximo 100 caracteres")
	private String nome;

	@Size(max = 100, message = "categoria deve ter no máximo 100 caracteres")
	private String categoria;

	private String descricao;

	public CompetenciaRequestDTO() {
	}

	public CompetenciaRequestDTO(String nome, String categoria, String descricao) {
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
