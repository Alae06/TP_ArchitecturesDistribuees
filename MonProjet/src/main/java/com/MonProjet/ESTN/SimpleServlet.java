package com.MonProjet.ESTN;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Date;
import java.util.Enumeration;


@WebServlet("/SimpleServlet")
public class SimpleServlet implements Servlet {

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		arg1.setContentType("text/html");
		 PrintWriter out = arg1.getWriter();      
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Simple Servlet Generic</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h1 align='center'>Simple Servlet Generic</h1>");	     
		 out.println("<p align='center'>Nous sommes le " + new Date().toString() + "</p>");
		 out.println("<table align='center'>");
		 out.println("<tr>");
	     out.println("<td colspan=2>Liste des paramètres:</td>");
	     out.println("</tr>");
	     
	     for(Enumeration<String> paramList= arg0.getServletContext().getInitParameterNames();paramList.hasMoreElements();) {
	        	String param = paramList.nextElement();
	        	out.println("<tr>");
	            out.println("<td>"+param+"</td>");
	            out.println("<td>"+ arg0.getServletContext().getInitParameter(param) +"</td>");
	            out.println("</tr>");
	        }
		 
		 out.println("</table >");
		 out.println("</body>");
		 out.println("</html>");
		
	}
	

}