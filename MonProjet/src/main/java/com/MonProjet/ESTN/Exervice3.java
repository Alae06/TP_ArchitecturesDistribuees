package com.MonProjet.ESTN;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Exervice3 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>requete GET</title>");
		 out.println("</head>");
		 out.println("<body>");
		 formulaire(out);

		 out.println("</body>");
		 out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int nombre1 = Integer.parseInt(request.getParameter("monParametre"));
        int nombre2 = Integer.valueOf(request.getParameter("monParametre2"));
        
        int resultat = nombre1 + nombre2;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
		out.println("<head>");
	    out.println("<title>requete POST</title>");
		out.println("</head>");
		out.println("<body>");
		
		formulaire(out);
        out.println("<h2>Calcul réussi !</h2>");
        out.println("<p><strong>" + nombre1 + " + " + nombre2 + " = " + resultat + "</strong></p>");
        
        out.println("</body>");
		out.println("</html>");
		
		 
	}
	public void formulaire(PrintWriter out) {
		 out.println("<form action='add' method=POST> ");	
		 out.println("<label for='n1'>Premier nombre :</label>");
		 out.println("<input type=text size=20 name=monParametre> ");
         out.println("<label for='n2'>Deuxième nombre :</label>");
		 out.println("<input type=text size=20 name=monParametre2> ");
		 out.println("<input type=submit> ");
		 out.println("</form> ");

	}
}
