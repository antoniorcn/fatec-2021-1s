package edu.fatec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurmaController {
	
	@Autowired
	AlunoRepositorio alunoRepository;
	
	@Autowired
	TurmaRepositorio turmaRepository;
	
	@RequestMapping(method = RequestMethod.GET,
			path = "/turmas")
	public ResponseEntity<List<Turma>> listarTurmas() { 
		List<Turma> entidades = turmaRepository.findAll();
		
		return ResponseEntity.ok(entidades);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/turma/add")
	public String adicionarTurma(@RequestBody Turma entidade) { 
		turmaRepository.save(entidade);
		return "Turma adicionada com sucesso";
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/turma/{nomeTurma}/{raAluno}")
	public String vincularTurmaAluno(	@PathVariable("nomeTurma") String nomeTurma, 
										@PathVariable("raAluno") String raAluno) { 
		Turma turma = turmaRepository.findByNome(nomeTurma);
		Aluno aluno = alunoRepository.findByRa(raAluno);
		
		List<Aluno> lista = new ArrayList<>();
		lista.add(aluno);
		turma.setAlunos(lista);
		
		turmaRepository.save(turma);
		return "Turma e aluno vinculados com sucesso";
	}
	

}
