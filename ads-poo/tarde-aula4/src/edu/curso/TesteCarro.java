package edu.curso;

public class TesteCarro {
	
	public static void main(String[] args) {
		Carro c1 = new Carro();
		
		Pneu step = c1.p1;
		Pneu pneuUsado = new Pneu();
		c1.p1 = pneuUsado;
		
		c1 = null;
		
		Ferrari f1 = new Ferrari();
		f1.p1 = new Pneu();
		
		
	}

}
