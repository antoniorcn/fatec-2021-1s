package edu.curso;

public class PizzaNutella implements Pizza, Doce {

	@Override
	public void servir() {
		System.out.println("Servindo com muito chocolate");
	}

	@Override
	public void lambusar() {
		System.out.println("Bastante guarnapo para limpar a bagunça");
	}

}
