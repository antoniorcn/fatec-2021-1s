package edu.curso;

public class TesteAnimais {
	
	public static void main(String[] args) {
		Animal a1 = new Humano();
		Humano h1 = new Humano();
		h1.comer();
		a1.comer();
		
		Macaco m1 = new Macaco();
		m1.comer();
		
		// Humano h2 = new Macaco();
		Macaco m2 = new Humano();
		
		Humano h3 = new Humano();

		Macaco m4 = h3;


	}

}
