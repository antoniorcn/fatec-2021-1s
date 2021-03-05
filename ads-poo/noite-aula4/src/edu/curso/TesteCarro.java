package edu.curso;

public class TesteCarro {
	public static void main(String[] args) {
		Carro c1 = new Carro();
		
		Pneu step = c1.p1;
		Pneu p2 = new Pneu();
		p2.setRaio(-15);
		c1.p1 = p2;
		
		System.out.println(p2.getRaio());
	}
}
