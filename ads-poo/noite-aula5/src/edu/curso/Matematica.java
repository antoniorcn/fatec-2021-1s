package edu.curso;

public class Matematica<T extends Number> {
	
	public double somar(T n1, T n2) {
		return n1.doubleValue() + n2.doubleValue();
	}
	
	public T multiplicar(T n1, T n2) { 
		return null;
	}

}
