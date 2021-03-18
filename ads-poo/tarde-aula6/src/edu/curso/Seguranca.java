package edu.curso;

public class Seguranca {
	
	static final private String senha = "123456";
	
	public void autenticar(MinhaString senha) { 
		if (senha.equals(this.senha)) { 
			System.out.println("Esta autenticado");
		} else { 
			System.out.println("Erro de usuário e senha");
		}
	}

}
