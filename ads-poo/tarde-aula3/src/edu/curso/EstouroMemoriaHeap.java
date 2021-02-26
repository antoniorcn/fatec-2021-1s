package edu.curso;

class No { 
	long[] vetor = new long[1000];
	No proximo;
}

public class EstouroMemoriaHeap {
	public static void main(String[] args) {
		System.out.println("Programa iniciado");
		No temp = new No();
		No raiz = temp;	
		while ( true ) { 
			temp.proximo = new No();
			temp = temp.proximo;
		}
	}
}
