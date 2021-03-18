package edu.curso;

public class Restaurante {

	public static void main(String[] args) {
		System.out.println("Restaurante Aberto");
		Pizza p1 = new PizzaMussarela();
		Pizza p2 = new PizzaCalabresa();
		
		p1.preparar();
		p1.assar();
		p1.servir();
		
		p2.preparar();
		p2.assar();
		p2.servir();

		System.out.println("Restaurante Fechado");
	}
}
