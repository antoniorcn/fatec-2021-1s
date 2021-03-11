package edu.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

	@RequestMapping(
			value="/alunos", 
			method=RequestMethod.GET,
			produces = {"application/JSON"} )
	public List<Aluno> listarTodos() { 	
		Aluno a1 = new Aluno();
		a1.setRa("00001");
		a1.setNome("João Silva");
		a1.setNascimento("05/09/2000");
		
		Aluno a2 = new Aluno();
		a2.setRa("00002");
		a2.setNome("Maria Silva");
		a2.setNascimento("14/10/2001");
		
		List<Aluno> lista = Arrays.asList(a1, a2);
		return lista;
	}
	
}
