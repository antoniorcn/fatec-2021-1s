package edu.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {
	
	@GetMapping("/hello")
	public String hello() { 
		return "index";
	}
	
	@GetMapping("/aluno")
	public ModelAndView aluno() { 
		
		Aluno a1 = new Aluno();
		a1.setId(2l);
		a1.setRa("0002");
		a1.setNome("Maria Silva");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno");
		mv.addObject("aluno1", a1);
		
		return mv;
	}
}
