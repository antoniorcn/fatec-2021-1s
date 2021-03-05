package edu.curso;

public class AlunoFatec extends Pessoa {

	AlunoFatec(String nome) { 
		super(nome);
	}
	
	AlunoFatec() { 
		super("");
		System.out.println("Instanciando AlunoFatec");
	}
}
