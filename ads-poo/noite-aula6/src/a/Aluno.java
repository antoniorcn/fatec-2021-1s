package a;

public class Aluno {
	
	static { 
		System.out.println("Carregando a classe Aluno");
	}
	
	public static int contadorAlunos;
	
	public Aluno() { 
		Aluno.contadorAlunos += 1;
	}

}
