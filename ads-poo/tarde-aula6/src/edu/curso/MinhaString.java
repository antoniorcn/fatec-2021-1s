package edu.curso;

public class MinhaString { 
	private String valor;
	
	MinhaString(String valor) { 
		this.valor = valor;
	}
	
	public boolean equals(String str) { 
		return str.equals(valor);
	}
}