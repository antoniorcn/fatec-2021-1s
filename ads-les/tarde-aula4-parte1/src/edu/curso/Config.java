package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean(name = "aluno")
	public Aluno criarAluno() { 
		Aluno a = new Aluno();
		a.setId(1l);
		a.setRa("0001");
		a.setNome("João Silva");
		return a;
	}
}
