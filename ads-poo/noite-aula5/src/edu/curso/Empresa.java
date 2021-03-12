package edu.curso;

public class Empresa {
	String nome;
	
//	Mecanico m;
//	
//	public void defineMecanico(Mecanico m) { 
//		this.m = m;
//	}
	
	Empresa(String nome) { 
		this.nome = nome;
	}
	
	public void produzirMotor(Mecanico m) { 
		System.out.println(this.nome + " montando o motor");
		m.montarMotor();
	}
}
