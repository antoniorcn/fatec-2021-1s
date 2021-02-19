package edu.fatec;

public class TesteMemoria {
	
	int soma = 10;	// Variável de Instância
	final static float PI = 3.1415f;
	
	public void teste() { 
		// int soma = 10;  // Variável Local
					       // Shadowing (Sombreamento)
		
		soma = 1;
		// int soma_total_salarios_mensal_funcionarios_rh = 1;
		int somaTotalSalariosMensalFuncionariosRh = 1; // CamelCase
		// Precisa retirar este codigo
		int soma = 10;
		// Esta variavel serve para guardar o Total de Salarios Menasais dos 
		// funcionarios de RH
		
		soma += 20;
	}
	

	public static void main(String[] args) {
	
	}

}
