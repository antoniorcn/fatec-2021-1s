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
public class MedicoController {
	
	@Autowired
	MedicoRepository medicoRepository;

	@RequestMapping(value="/medicos", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Medico>> listaMedicos(HttpServletResponse response) {
	    response.addHeader("Content-Type", "application/json");
	    
	    List<Medico> lista = medicoRepository.findAll();
	    		
		return ResponseEntity.ok(lista);
	}
	
	
	@RequestMapping(value="/medico/{crm}", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Medico>> medicoPorCRM(HttpServletResponse response,
			@PathVariable("crm") Optional<String> crm) {
	    response.addHeader("Content-Type", "application/json");
	    
	    List<Medico> retorno = new ArrayList<>();
	    
	    if (crm.isPresent()) {
	    	Medico m1 = medicoRepository.findByCrm(crm.get());
	    	retorno.add( m1 );
	    } else { 
	    	retorno = medicoRepository.findAll();
	    }
	    		
		return ResponseEntity.ok(retorno);
	}
	
	@RequestMapping(value="/medico/add", 
			method=RequestMethod.POST)
	public String adicionar(@RequestBody Medico medico) { 
		medicoRepository.save(medico);
		System.out.println(medico.getNome() + " - " + medico.getEspecialidade());
		return "Ok Medico cadastrado com sucesso";
	}

}
