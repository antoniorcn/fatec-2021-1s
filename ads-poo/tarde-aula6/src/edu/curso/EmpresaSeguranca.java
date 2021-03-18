package edu.curso;

public class EmpresaSeguranca {

	public static void main(String[] args) {
		MinhaString str = new MinhaString("111");
		
		double resultado = Math.pow(10, 2);
		System.out.println("Res: " + resultado);
		
		Seguranca seg1 = new Seguranca();
		Seguranca seg2 = new Seguranca();
		Seguranca seg3 = new Seguranca();
		seg1.autenticar(str);
	}
	
}
