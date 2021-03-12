package edu.curso;

public class Empresa {
	
	RH rh;
	
	public Empresa(RH rh) { 
		this.rh = rh;
	}
	
	public void gerarFolhaPagamento() { 
		rh.pagarSalarios();
	}

}
