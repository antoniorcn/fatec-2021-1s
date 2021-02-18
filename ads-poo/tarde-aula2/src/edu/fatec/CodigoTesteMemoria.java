package edu.fatec;

class Aluno { 
	String nome;
	String ra;
	
	public Aluno(String ra, String nome) { 
		this.ra = ra;
		this.nome = nome;
	}
	
	public void mostrarNaTela() { 
		int j = 16;
		//System.out.println("RA : " + ra + "   Nome: " + nome);
		System.out.printf("RA: %s   Nome: %s \n", this.ra, this.nome);
	}
}

public class CodigoTesteMemoria {
	public static void main(String[] args) {
		int a = 10;
		Aluno a1 = new Aluno("0001", "Antonio");
		Aluno a2 = new Aluno("0002", "Jo�o");
		Aluno a3 = new Aluno("0003", "Maria");
		a2.mostrarNaTela();
		a3.mostrarNaTela();
	}
}
