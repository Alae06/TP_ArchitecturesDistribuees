package com.MonProjet.ESTN;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();      
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>MaServlet</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h1 align='center'> Bonjour le monde</h1>");	     
		 out.println("<p align='center'>Nous sommes le " + new Date().toString() + "</p>");
		 out.println("</body>");
		 out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
