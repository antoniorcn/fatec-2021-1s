package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
	
	@GetMapping("/")
	public String boasVindas() { 
		return "welcome";
	}
	
	@GetMapping("/dados")
	public ModelAndView boasVindasComDados() { 
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("PET1", "Totó");
		mv.addObject("PET2", "Rex");
		return mv;
	}
	

}
