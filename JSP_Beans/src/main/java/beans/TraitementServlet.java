package beans;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TraitementServlet")
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
		
		if (etudiant == null) {
			etudiant = new Etudiant();
		}
		
		double noteAleatoire = Math.random() * 20;
		etudiant.setNote(noteAleatoire);
		
		request.setAttribute("etudiant", etudiant);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/reponse.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
