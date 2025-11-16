package com.MonProjet.ESTN;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.Enumeration;


@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        

        out.println("<html><body>");

        out.println("<h2 align='center'>TP n°1</h2>");
        
        out.println("<table align='center'>");
        out.println("<tr>");
        out.println("<td>Type mime de la requête : </td>");
        out.println("<td>"+ request.getContentType() + "</td>");
        out.println("</tr>");
        
        
        out.println("<tr>");
        out.println("<td>Protocole :</td>");
        out.println("<td>" + request.getProtocol() +"</td>");
        out.println("</tr>");
        
        
        out.println("<tr>");
        out.println("<td>Adresse IP du client :</td>");
        out.println("<td>"+ request.getRemoteAddr() + "</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Nom du client :</td>");
        out.println("<td>"+ request.getRemoteHost() +"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Nom du serveur :</td>");
        out.println("<td>" + request.getServerName() + "</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Port du serveur :</td>");
        out.println("<td>" + request.getServerPort() + "</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Scheme :</td>");
        out.println("<td>"+ request.getScheme() +"</td>");
        out.println("</tr>");
        
        
        out.println("<tr>");
        out.println("<td colspan=2>Liste des paramètres:</td>");
        out.println("</tr>");
        
        for(Enumeration<String> paramList= request.getParameterNames();paramList.hasMoreElements();) {
        	String param = paramList.nextElement();
        	out.println("<tr>");
            out.println("<td>"+param+ ":</td>");
            out.println("<td>"+ request.getParameter(param) +"</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");

        out.println("</body></html>");
        
		
        
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
