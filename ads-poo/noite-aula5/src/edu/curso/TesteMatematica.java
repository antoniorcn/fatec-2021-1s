package edu.curso;

public class TesteMatematica {
	
	public static void main(String[] args) {
		
		Matematica<Short> mat = new Matematica<>();
		
		Double s = mat.somar((short)10,  (short)5);
		System.out.println(s);
		
		Matematica<Double> mat2 = new Matematica<>();
		
	
	}

}
