package com.estn.controller;

import java.io.IOException;
import java.util.List;

import com.estn.model.Client;
import com.estn.model.ClientDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    
    private ClientDAO clientDAO = new ClientDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }
        
        if (action.equals("list")) {
            afficherListe(request, response);
        } else if (action.equals("add")) {
            afficherFormulaireAjout(request, response);
        } else if (action.equals("edit")) {
            afficherFormulaireModification(request, response);
        } else if (action.equals("delete")) {
            supprimerClient(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if (action.equals("add")) {
            ajouterClient(request, response);
        } else if (action.equals("edit")) {
            modifierClient(request, response);
        }
    }

    private void afficherListe(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Client> clients = clientDAO.listerClients();
        
        request.setAttribute("clients", clients);
        
        request.getRequestDispatcher("/WEB-INF/views/listeClients.jsp").forward(request, response);
    }

    private void afficherFormulaireAjout(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/WEB-INF/views/ajouterClient.jsp").forward(request, response);
    }

    private void ajouterClient(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String ageStr = request.getParameter("age");
        
        int age = Integer.parseInt(ageStr);
        
        Client client = new Client(nom, prenom, age);
        
        clientDAO.ajouterClient(client);
        
        response.sendRedirect("client");
    }

    private void afficherFormulaireModification(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        
        Client client = clientDAO.getClientById(id);
        
        request.setAttribute("client", client);
        
        request.getRequestDispatcher("/WEB-INF/views/modifierClient.jsp").forward(request, response);
    }

    private void modifierClient(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String ageStr = request.getParameter("age");
        
        int id = Integer.parseInt(idStr);
        int age = Integer.parseInt(ageStr);
        
        Client client = new Client(id, nom, prenom, age);
        
        clientDAO.modifierClient(client);
        
        response.sendRedirect("client");
    }

    private void supprimerClient(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        
        clientDAO.supprimerClient(id);
        
        response.sendRedirect("client");
    }
}