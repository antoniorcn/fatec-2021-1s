package edu.curso.medicos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Consulta {
	
	private long id;
	private List<Medico> medicos = new ArrayList<>();
	private String descricao = "";
	private String nomePaciente = "";
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medico) {
		this.medicos = medico;
	}
	
	@Column(length = 255)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(length = 100)
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
}
