package com.estn.presentation.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.estn.dao.entities.Client;
import com.estn.metier.IClientService;
import com.estn.presentation.model.RechercheModel;


@WebServlet("*.do")
public class ClientServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private IClientService metier;
    
   @Override
public void init(ServletConfig config) throws ServletException {
	
	super.init(config);
	
	ApplicationContext ac = new AnnotationConfigApplicationContext("com.estn.dao","com.estn.metier");
	metier = ac.getBean(IClientService.class);
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		
		switch (path) {
		case "/accueil.do":{ 
			
			String motCle = request.getParameter("motCle");
			if(motCle == null)
				motCle ="";
			List<Client> clients = metier.rechercherClientParNom(motCle);
			
			RechercheModel rm= new RechercheModel();
			rm.setClients(clients);
			rm.setMotCle(motCle);
			
			request.setAttribute("rm", rm);
			request.getRequestDispatcher("vues/index.jsp").forward(request, response);
			break;
		}	
		case "/nouveauClient.do":{
			request.getRequestDispatcher("vues/nouveauClient.jsp").forward(request, response);
			
			break;
		}
		case "/ajouterClient.do":{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			
			
			Client client = new Client(null,nom,prenom,age);
			metier.enregistrerClient(client);
			request.getRequestDispatcher("accueil.do").forward(request, response);

			
			break;
		}
		case "/editer.do":{
			Long id=Long.parseLong(request.getParameter("id"));
			Client client = metier.recupererClient(id);
			metier.modifierClient(client, id);
			
			request.setAttribute("client", client);
			request.getRequestDispatcher("vues/editerClient.jsp").forward(request, response);
			break;
			
		}
		case "/modifierClient.do":{
			Long id= Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));
			
			
			Client client = new Client(id,nom,prenom,age);
			metier.modifierClient(client, id);
			request.getRequestDispatcher("accueil.do").forward(request, response);

			
			break;
		}
		case "/supprimer.do":{
			Long id=Long.parseLong(request.getParameter("id"));
			metier.supprimerClient(id);
			
			request.getRequestDispatcher("accueil.do").forward(request, response);
			break;
		}
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
