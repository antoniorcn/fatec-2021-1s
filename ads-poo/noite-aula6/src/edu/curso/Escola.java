package edu.curso;

import a.Aluno;

public class Escola {

	public static void main(String[] args) {
		System.out.println("Abertura da Escola");
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		synchronized (a1){ 
			System.out.println(Aluno.contadorAlunos);
		}
		System.out.println("Fechamento da Escola");
	}
	
	static private native final int[] calcularNumerosPrimos();
	
	public void fazerChavedeCriptografia() { 
		calcularNumerosPrimos();
	}
	
	public synchronized strictfp double calcularDigitos() { 
		double pi = 3.1415;
		return 0;
	}
}
