package edu.curso;

public interface Pizza {
	
	int fatias = 8;
	
	default void preparar() { 
		System.out.println("Preparando");
	}
	
	default void assar() { 
		System.out.println("Assando");
	}
	
	void servir();

}
