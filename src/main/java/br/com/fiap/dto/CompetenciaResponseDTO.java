package br.com.fiap.dto;

public class CompetenciaResponseDTO {

	private Long id;
	private String nome;
	private String categoria;
	private String descricao;

	public CompetenciaResponseDTO() {
	}

	public CompetenciaResponseDTO(Long id, String nome, String categoria, String descricao) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.descricao = descricao;
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
