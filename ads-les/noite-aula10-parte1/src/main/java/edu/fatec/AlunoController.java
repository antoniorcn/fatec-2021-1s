package edu.fatec;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AlunoController {
	
	@Autowired
	AlunoRepositorio alunoRepository;

	@Value("${quantidade.maxima.items_por_pagina}")
	private int quantidadeMaximaItemsPorPagina;
	
	@RequestMapping(method = RequestMethod.GET,
			value = {"/alunos", "/alunos/{numeroPagina}", "/alunos/{numeroPagina}/{qtdItems}"})
	public ResponseEntity<List<Aluno>> listarAlunos(
			@PathVariable("numeroPagina") Optional<Integer> numeroPagina,
			@PathVariable("qtdItems") Optional<Integer> qtdItems) {

		System.out.println("Quantidade Items por Pagina==>" + quantidadeMaximaItemsPorPagina);

		int numPagina = numeroPagina.orElse(0);
		int qtdItemsPorPagina = qtdItems.orElse( 3 );

		qtdItemsPorPagina = qtdItemsPorPagina > quantidadeMaximaItemsPorPagina ?
				quantidadeMaximaItemsPorPagina : qtdItemsPorPagina;

		Pageable paginacao = PageRequest.of(numPagina, qtdItemsPorPagina);

		Page<Aluno> alunos = alunoRepository.findAll(paginacao);
		return ResponseEntity.ok(alunos.getContent());
	}
	
	@RequestMapping(method = RequestMethod.POST,
			path = "/aluno/add")
	public String adicionarAluno(@RequestBody Aluno aluno) { 
		alunoRepository.save(aluno);
		return "Aluno adicionado com sucesso";
	}

}
