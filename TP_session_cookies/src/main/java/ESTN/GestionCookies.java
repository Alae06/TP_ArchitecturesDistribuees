package ESTN;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;

@WebServlet("/accueil")
public class GestionCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bgcolor = null;
		String police = null;
		String type=null;
		int nbr = 0;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("bgcolor")) {
			   bgcolor=cookies[i].getValue();
		    }
			if(cookies[i].getName().equals("police")) {
				police=cookies[i].getValue();
			    }
			if(cookies[i].getName().equals("livre")) {
				type=cookies[i].getValue();
			    }
			if(cookies[i].getName().equals("nbr")) {
				nbr=Integer.parseInt(cookies[i].getValue());
			    }
			}
		}
		
		if(bgcolor==null && police==null && type==null) {
			response.sendRedirect(request.getContextPath()+"/index.html");
			
		}else {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();      
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Acceuil</title>");
		 out.println("</head>");
		 out.println("<body bgcolor='"+bgcolor+"'>");
		 out.println("<font color='"+police+"'>");
		 

		 
		 out.println("<h1>Bienvenue</h1>");	     
		 out.println("<center>votre nombre prefere est : "+nbr+"</center><br><br>");
		 if(type.equals("programmation")) {
			 out.println("<p>Programmer en java, Claude Delannoy</p>");
			 out.println("<p>Spring in Action, Rode Jhonson</p>");

		 }else if(type.equals("security")) {
			 out.println("<p>Sécurité Réseaux, Claude Delannoy</p>");
			 out.println("<p>CyberSecurity, Rode Jhonson</p>");

		 }else if(type.equals("ingenierie")) {
			 out.println("<p>MDA on Action, Claude Delannoy</p>");
			 out.println("<p>Modélisation UML, Rode Jhonson</p>");

		 }
		 
		 
		 out.println("</font>");
		 out.println("</body>");
		 out.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
