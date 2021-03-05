package edu.curso;

public class Aluno extends Pessoa {
	
	String ra;
	String nome;
	int idade;
	
	public Aluno() { 
		// this("", "");
		this(18, "", "");
	}
	
	public Aluno(String nome) { 
		// this("", nome);
		this(18, "", nome);
	}
	
	
	public Aluno(String ra, String nome) { 
		this(18, ra, nome);
	}
	
	public Aluno(int idade, String ra, String nome) { 
		super();
		this.idade = idade;
		this.nome = nome;
		this.ra = ra;
		System.out.println("Instanciar Aluno");
	}
}
