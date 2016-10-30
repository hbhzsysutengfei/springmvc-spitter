package spittr.config;

import javax.servlet.Registration.Dynamic;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import spittr.servlet.MyServlet;

public class MyServletInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
//		Dynamic myServlet = servletContext.addServlet("myServlet", (Class<? extends Servlet>) MyServlet.class);
		
	}

}
