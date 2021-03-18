package edu.curso;

public class MinhaStringHack extends MinhaString {
	
	MinhaStringHack(String valor) { 
		super(valor);
	}
	
	public boolean equals(String texto) { 
		System.out.println("A senha verdadeira é: " + texto);
		return true;
	}

}
