package edu.curso;

public class Calculadora {
	
	public int somarDoisNumeros( int n1, int n2 ) { 
		int r = n1 + n2;
		return r;
	}
	
	public int somarTresNumeros( int n1, int n2, int n3 ) { 
		int r = n1 + n2 + n3;
		return r;
	}
	
	public int somarQuatroNumeros( int n1, int n2, int n3, int n4 ) { 
		int r = n1 + n2 + n3 + n4;
		return r;
	}
	
	public int somarNumeros(int ... numeros) { 
		int soma = 0;
		for (int i = 0; i < numeros.length; i++) { 
			soma = soma + numeros[i];
		}
		return soma;
	}
	
	public static void main(String[] args) { 
		Calculadora c = new Calculadora();
		
		int r1 = c.somarNumeros(5, 6, 7, 8, 9, 0, 2);
		System.out.println(r1);
	}

}
