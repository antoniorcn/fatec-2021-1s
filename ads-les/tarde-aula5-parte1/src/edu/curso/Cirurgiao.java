package edu.curso;

import javax.persistence.Entity;

@Entity
public class Cirurgiao extends Medico {
	
	private String experiencia;

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

}
