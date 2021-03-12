package edu.curso;

public class TesteEmpresa {
	public static void main(String[] args) {
		
		Empresa e1 = new Empresa("Ford");
		Empresa e2 = new Empresa("GM");
		
		Mecanico m1 = new MecanicoCorp();
		Mecanico m2 = new MecanicoCorp();
		Mecanico m3 = new MecanicoCorp();
		Mecanico m4 = new MecanicoCorp();
		Mecanico m5 = new MecanicoCorp();
		
		e1.produzirMotor(m1);
		e2.produzirMotor(m2);
		e1.produzirMotor(m3);
		e2.produzirMotor(m1);
		e1.produzirMotor(m5);
	}
}
