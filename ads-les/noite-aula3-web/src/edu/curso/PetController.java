package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetController {
	
	@GetMapping("/")
	public String boasVindas() { 
		return "welcome";
	}

}
