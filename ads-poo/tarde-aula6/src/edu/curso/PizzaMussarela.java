package edu.curso;

public class PizzaMussarela implements Pizza {

	@Override
	public void servir() { 
		System.out.println("Pizza fatiada em 8 peda�os e servida");
	}

	@Override
	public void assar() {
		System.out.println("Assando a pizza");
		
	}
	
}
