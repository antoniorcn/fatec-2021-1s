package edu.fatec;

class Aluno { 
	String ra;
	String nome;
	
	public Aluno(String ra, String nome) { 
		this.ra = ra;
		this.nome = nome;
	}
	
	public void mostrarNaTela() { 
		System.out.println("RA: " + this.ra + "  Nome: " + this.nome);
	}
}

public class TesteMemoria2 {
	public static void main(String[] args) {
		int i1 = 10;
		float f1 = 56.4f;
		Aluno a1 = new Aluno("0001", "João");
		Aluno a2 = new Aluno("0002", "Maria");
		
		Aluno a3 = a1;
		
		a1.mostrarNaTela();
		a2.mostrarNaTela();
	}
}
