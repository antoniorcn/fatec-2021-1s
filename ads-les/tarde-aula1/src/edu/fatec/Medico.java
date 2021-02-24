package edu.fatec;

public class Medico {
	private long id;
	private String crm;
	private String nome;
	private String especialidade;
	
	public Medico(String crm, String nome, String especialidade) {
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
