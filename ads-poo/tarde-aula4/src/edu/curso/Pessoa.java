package edu.curso;

public class Pessoa extends Animal {
	String nome;
	
	Pessoa(String nome) { 
		super();
		this.nome = nome;
		System.out.println("Instanciando uma pessoa");
	}

}
