package edu.curso;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorDados {
	
	@RequestMapping(value="/alunoJSON", 
					method=RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Aluno> dadosAluno(HttpServletResponse response) {
	    response.addHeader("Content-Type", "application/json");
	    
		Aluno a1 = new Aluno();
		a1.setId(2l);
		a1.setRa("0002");
		a1.setNome("Maria Silva");
		
		return ResponseEntity.ok(a1);
	}

}
