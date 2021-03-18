package edu.curso;

abstract public class Pizza8Queijos implements Pizza {
	
	public void servir(int pedacos) { 
		System.out.println("Servindo um queijo por vez");
	}
	
	public void servir() { 
		System.out.println("Dividindo em 8 pedaços");
	}
	
	abstract public void dividir();

}
