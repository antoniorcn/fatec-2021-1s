package edu.curso;

class No { 
	No proximo;
	long[] payload = new long[1000];
}
public class EstouroMemoriaHeap {
	public static void main(String[] args) {
		System.out.println("Sistema iniciado");
		No temp = new No();
		No raiz = temp;
		while( true ) { 
			temp.proximo = new No();
			temp = temp.proximo;
		}
	}
}
