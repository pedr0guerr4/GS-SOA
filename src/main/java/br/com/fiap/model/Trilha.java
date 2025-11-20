package br.com.fiap.model;

import br.com.fiap.enums.NivelTrilha;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trilhas")
public class Trilha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private NivelTrilha nivel;

	@Column(name = "carga_horaria", nullable = false)
	private Integer cargaHoraria;

	@Column(name = "foco_principal", length = 100)
	private String focoPrincipal;

	@ManyToMany
	@JoinTable(name = "trilha_competencia", joinColumns = @JoinColumn(name = "trilha_id"), inverseJoinColumns = @JoinColumn(name = "competencia_id"))
	private Set<Competencia> competencias = new HashSet<>();

	public Trilha() {
	}

	public Trilha(Long id, String nome, String descricao, NivelTrilha nivel, Integer cargaHoraria,
			String focoPrincipal) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.nivel = nivel;
		this.cargaHoraria = cargaHoraria;
		this.focoPrincipal = focoPrincipal;
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

	public Set<Competencia> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(Set<Competencia> competencias) {
		this.competencias = competencias;
	}
}
