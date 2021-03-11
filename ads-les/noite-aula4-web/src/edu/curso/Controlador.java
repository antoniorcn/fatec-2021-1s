package edu.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Controlador {
	
	@Autowired
	ApplicationContext ctx;

	@RequestMapping(
			value="/alunos", 
			method=RequestMethod.GET,
			produces = {"application/JSON"} )
	public List<Aluno> listarTodos() { 	
//		Aluno a1 = new Aluno();
//		a1.setRa("00001");
//		a1.setNome("João Silva");
//		a1.setNascimento("05/09/2000");
//		
//		Aluno a2 = new Aluno();
//		a2.setRa("00002");
//		a2.setNome("Maria Silva");
//		a2.setNascimento("14/10/2001");
		List<Aluno> lista = (List<Aluno>)ctx.getBean("produzLista");
		return lista;
	}
	
	@RequestMapping(
			value="/adicionarAluno", 
			method=RequestMethod.POST,
			consumes = {"application/JSON"} )
	public ResponseEntity<String> adicionarAluno(@RequestBody Aluno a) { 
		List<Aluno> lista = (List<Aluno>)ctx.getBean("produzLista");
		lista.add(a);
		return ResponseEntity.ok("Ok");
	}
	
}
