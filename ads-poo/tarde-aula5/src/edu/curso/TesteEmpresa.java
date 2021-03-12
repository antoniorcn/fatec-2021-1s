package edu.curso;

public class TesteEmpresa {
	public static void main(String[] args) {
		RH rh1 = new RH();
		RH rh2 = new RHEconomico();
		
		Empresa e = new Empresa(rh2);
		
		e.gerarFolhaPagamento();
	}
}
