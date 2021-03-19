package edu.curso;

public class Zoo {
	
	public static void main(String[] args) {
		System.out.println("Abriu o Zoologico");
		Gato g1 = new Gato();
		g1.fazerSom();
		g1.dormir();
		
		Cachorro c1 = new Cachorro();
		c1.fazerSom();
		System.out.println("Fechou o Zoologico");
	}

}
