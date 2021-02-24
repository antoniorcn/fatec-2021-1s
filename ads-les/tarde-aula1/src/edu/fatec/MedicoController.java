package edu.fatec;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/medico")
public class MedicoController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Medico Controller executado");
		
		String valorCRM = req.getParameter("crm");
		if (valorCRM == null) { 
			valorCRM = "";
		}
		
		Medico m1 = new Medico("0001", "Dr. Takagima", "Cardiologista");
		Medico m2 = new Medico("0002", "Dra. Pimentel", "Ginecologista");
		Medico m3 = new Medico("0003", "Dr. Ronaldo", "Clinico Geral");
		Medico[] medicos = {m1, m2, m3};
		List<Medico> medicosEncontrados = new ArrayList<>();
		for (Medico m : medicos) { 
			if (m.getCrm().contains(valorCRM)) { 
				medicosEncontrados.add(m);
			}
		}
		
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
}
