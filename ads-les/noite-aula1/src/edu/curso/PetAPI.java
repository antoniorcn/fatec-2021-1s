package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;


class Pet { 
	public String nome;
	public int idade;
	
	Pet(String nome, int idade) { 
		this.nome = nome;
		this.idade = idade;
	}
}


@WebServlet("/pet")
public class PetAPI implements Servlet {
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		System.out.println("API foi invocada....");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
//		out.println("data: ["); 
//		out.println("{nome:\"toto\", idade:10}, ");
//		out.println("{nome:\"rex\", idade:13}, ");
//		out.println("{nome:\"fifi\", idade:5}, ");
//		out.println("]");
		Pet p1 = new Pet("Toto", 10);
		Pet p2 = new Pet("Rex", 13);
		Pet p3 = new Pet("Fifi", 5);
		Pet[] pets = {p1, p2, p3};
		String json = gson.toJson(pets);
		out.println(json);
	}
}
