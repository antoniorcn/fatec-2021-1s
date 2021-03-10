package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TesteSpring {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Config.class);
		Aluno a1 = ctx.getBean("aluno", Aluno.class);
		Aluno a2 = ctx.getBean("aluno", Aluno.class);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println("Nome: " + a1.getNome());
	}

}
