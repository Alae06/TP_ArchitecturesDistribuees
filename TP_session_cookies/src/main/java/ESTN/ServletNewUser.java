package ESTN;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/newUser")
public class ServletNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String bgColor = request.getParameter("bgcol");
	    String police = request.getParameter("police");
	    String livre = request.getParameter("type");
	    int nbr = Integer.parseInt(request.getParameter("nbr"));
	    
	    Cookie c = new Cookie("bgcolor",bgColor);
	    c.setMaxAge(60*60*24);
	    response.addCookie(c);
	    
	    Cookie p = new Cookie("police",police);
	    p.setMaxAge(60*60*24);
	    response.addCookie(p);
	    
	    Cookie t = new Cookie("livre",livre);
	    t.setMaxAge(60*60*24);
	    response.addCookie(t);
	    
	    Cookie n = new Cookie("nbr",""+nbr);
	    n.setMaxAge(60*60*24);
	    response.addCookie(n);
	    
	    
	    response.setContentType("text/html");
		 PrintWriter out = response.getWriter();      
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>TPcookies</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h1>Bien enregistrée</h1>");	     
		 out.println("<center><a href='accueil'>Acceuil</a></center>");
		 out.println("</body>");
		 out.println("</html>");

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
