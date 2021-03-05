package edu.curso; 

public class Pneu { 
	private int raio = 14;

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		if (raio > 0) { 
			this.raio = raio;
		}
	}	
}