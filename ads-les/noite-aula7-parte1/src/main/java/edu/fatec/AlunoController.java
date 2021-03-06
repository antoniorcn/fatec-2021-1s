package edu.fatec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
	
	@Autowired
	AlunoRepositorio alunoRepository;
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/alunos")
	public ResponseEntity<List<Aluno>> listarAlunos() { 
		List<Aluno> alunos = alunoRepository.findAll();
		
		return ResponseEntity.ok(alunos);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/aluno/add")
	public String adicionarAluno(@RequestBody Aluno aluno) { 
		alunoRepository.save(aluno);
		return "Aluno adicionado com sucesso";
	}

}
