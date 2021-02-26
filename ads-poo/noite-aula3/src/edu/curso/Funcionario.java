package edu.curso;

public class Funcionario {
	float salario;
//	public void adicionarBeneficios(float b1, float b2, float b3) { 
//		this.salario += b1;
//		this.salario += b2;
//		this.salario += b3;
//	}
//	public void adicionarBeneficios(float b1, float b2) { 
//		this.salario += b1;
//		this.salario += b2;
//	}
//	public void adicionarBeneficios(float b1) { 
//		this.salario += b1;
//	}
	
	public void adicionarBeneficios(float ... b) { 
		for (int i = 0; i < b.length; i++) { 
			System.out.println(b[i]);
			this.salario += b[i];
		}
	}
	
	public static void main(String ... args) {
		Funcionario f1 = new Funcionario();
		f1.adicionarBeneficios(150.0f, 350.0f, 450.0f);
		
//		Funcionario f2 = new Funcionario();
//		f2.adicionarBeneficios(125.0f);
//		
//		Funcionario f3 = new Funcionario();
//		f3.adicionarBeneficios(150.0f, 350.0f, 200.0f);
	}

}
