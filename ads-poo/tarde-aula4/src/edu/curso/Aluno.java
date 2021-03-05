package edu.curso;

public class Aluno {
	
	String ra;
	String nome;
	
	public Aluno(String ra, String nome) { 
		this.nome = nome;
		this.ra = ra;
		System.out.println("Aluno instanciado");
	}
	
	public Aluno(String nome) { 
		this("", nome);
//		this.nome = nome;
//		System.out.println("Aluno instanciado");
	}
	
	public Aluno() {
		this("");
//		System.out.println("Aluno instanciado");
	}
	
	
	
	public static void main(String... args) { 
		Aluno a1 = new Aluno("0001", "João Silva");
//		a1.ra = "0001";
//		a1.nome = "João Silva";
	}

}
