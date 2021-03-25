package edu.curso.medicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaController {
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	MedicoRepository medicoRepository;

	@RequestMapping(value="/consultas", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Consulta>> listaConsultas(HttpServletResponse response) {
	    response.addHeader("Content-Type", "application/json");
	    
	    List<Consulta> lista = consultaRepository.findAll();
	    		
		return ResponseEntity.ok(lista);
	}
	
	
	@RequestMapping(value="/consulta/{nomePaciente}", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Consulta>> medicoPorCRM(HttpServletResponse response,
			@PathVariable("nomePaciente") Optional<String> nomePaciente) {
	    response.addHeader("Content-Type", "application/json");
	    
	    List<Consulta> retorno = new ArrayList<>();
	    
	    if (nomePaciente.isPresent()) {
	    	List<Consulta> m1 = consultaRepository.findByNomePaciente(nomePaciente.get());
	    	retorno.addAll( m1 );
	    } else { 
	    	retorno = consultaRepository.findAll();
	    }
	    		
		return ResponseEntity.ok(retorno);
	}
	
	@RequestMapping(value="/consulta/add", 
			method=RequestMethod.POST)
	public String adicionar(@RequestBody Consulta consulta) {
		Medico m = medicoRepository.findByCrm("000004");
		consulta.setMedico(m);
		consultaRepository.save(consulta);
		return "Ok Consulta cadastrada com sucesso";
	}

}
