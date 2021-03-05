package edu.curso;

public class TesteVarArgs {
	
	static int somar(String a, int ... numeros) { 
		int soma = 0;
		for (int i = 0; i < numeros.length; i++) { 
			soma += numeros[i];
		}
		return soma;
	}
	
	public static void main(String[] args) {
		System.out.println( somar("") );
	}

}
