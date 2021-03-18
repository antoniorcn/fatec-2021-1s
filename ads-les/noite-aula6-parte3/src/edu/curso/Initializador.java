package edu.curso;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCtx) throws ServletException {
		AnnotationConfigWebApplicationContext springCtx = 
				new AnnotationConfigWebApplicationContext();
		springCtx.setServletContext(servletCtx);
		springCtx.register(Config.class);
		
		Dynamic servlet = 
				servletCtx.addServlet("dispatcher", new DispatcherServlet(springCtx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);	
		System.out.println("Web Application Initializer Invocado...");
	}

}
