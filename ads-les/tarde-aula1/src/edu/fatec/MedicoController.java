package edu.fatec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/medico")
public class MedicoController extends HttpServlet {
	
	
	public List<Medico> getListaMedicos() { 
		List<Medico> medicosEncontrados = (List<Medico>)getServletContext().getAttribute("LISTA");
		if (medicosEncontrados == null) { 
			medicosEncontrados = new ArrayList<>();
			getServletContext().setAttribute("LISTA", medicosEncontrados);
		}
		return medicosEncontrados;
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Medico Controller executado");
		
		String valorCRM = req.getParameter("crm");
		if (valorCRM == null) { 
			valorCRM = "";
		}
		
		List<Medico> medicosEncontrados = getListaMedicos();
		
		Gson gson = new Gson();
		String medicosJSon = gson.toJson(medicosEncontrados);
		
		// res.setContentType("text/html"); // Mime Type
		res.setContentType("application/json"); // Mime Type
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
		res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		PrintWriter out = res.getWriter();
		// out.println("<h3>Servlet MedicoController foi acionado</h3>");	
		out.println(medicosJSon);
	}
	
	public void doOptions(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("text/plain"); // Mime Type
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		BufferedReader br = request.getReader();
		System.out.println("POST Acionado:");
		
		List<Medico> medicosEncontrados = getListaMedicos();
		
		StringBuffer sb = new StringBuffer();
		while (br.ready()) { 
			sb.append(br.readLine());
		}
		
		Gson gson = new Gson();
		Medico m = gson.fromJson(sb.toString(), Medico.class);
		medicosEncontrados.add(m);
		
		
		response.setContentType("text/plain"); // Mime Type
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,PATCH,OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		PrintWriter out = response.getWriter();
		out.println("OK");
	}
}
