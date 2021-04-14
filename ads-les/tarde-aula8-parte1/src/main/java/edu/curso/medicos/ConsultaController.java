package edu.curso.medicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(ConsultaController.class);
	
//	@Autowired
	ConsultaServicos consultaServicos;

	ConsultaController(ConsultaServicos consultaServicos) {
		this.consultaServicos = consultaServicos;
	}
	
	@RequestMapping(value="/consultas",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Consulta>> listaConsultas(HttpServletResponse response) {
	    response.addHeader("Content-Type", "application/json");
	    
	    List<Consulta> lista = consultaServicos.listarConsultas();
	    logger.trace("Log de Trace");
		logger.debug("Tamanho da lista ==> {}", lista.size());
		logger.info("Log de informação");
		logger.warn("Log de Warning");
		logger.error("Log de error");

		return ResponseEntity.ok(lista);
	}

	@RequestMapping(value="/consulta/{nomePaciente}", 
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Consulta>> consultaPorPaciente(HttpServletResponse response,
			@PathVariable("nomePaciente") Optional<String> nomePaciente) {
	    response.addHeader("Content-Type", "application/json");
	    
	    List<Consulta> retorno = new ArrayList<>();
	    
	    if (nomePaciente.isPresent()) {
	    	try {
				List<Consulta> m1 = consultaServicos.listarConsultasPorPaciente(nomePaciente.get());
				retorno.addAll( m1 );
			} catch (Exception e) {
				logger.error("Erro ao acessar o banco de dados==>", e);
			}
	    } else {
			logger.warn("Não foram encontradas consultas para o paciente ==> {}", nomePaciente.get());
	    	retorno = new ArrayList<>();
	    }
	    		
		return ResponseEntity.ok(retorno);
	}
	
	@RequestMapping(value="/consulta/add", 
			method=RequestMethod.POST)
	public String adicionar(@RequestBody Consulta consulta) {
		consultaServicos.adicionarConsulta(consulta);
		return "Ok Consulta cadastrada com sucesso";
	}

}
