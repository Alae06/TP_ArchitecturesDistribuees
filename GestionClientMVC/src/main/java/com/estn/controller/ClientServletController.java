package com.estn.controller;

import com.estn.model.Client;
import com.estn.model.ClientModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("*.php")
public class ClientServletController extends HttpServlet {
    private final ClientModel model = new ClientModel();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/Liste.php":
                String motCle = request.getParameter("motCle");
                if (motCle == null) motCle = "";
                List<Client> clients = model.getClients(motCle);
                request.setAttribute("clients", clients);
                request.getRequestDispatcher("Liste.jsp").forward(request, response);
                break;
              //+ le cas de Ajouter, modifer et supprimer:

            case "/Ajouter.php":
                if ("POST".equals(request.getMethod())) {
                    try {
                        int id = Integer.parseInt(request.getParameter("idClient"));
                        String nom = request.getParameter("nom");
                        String prenom = request.getParameter("prenom");
                        int age = Integer.parseInt(request.getParameter("age"));
                        model.ajouterClient(id, nom, prenom, age);
                        response.sendRedirect("Liste.php");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        request.getRequestDispatcher("Ajouter.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("Ajouter.jsp").forward(request, response);
                }
                break; 

            case "/Modifier.php":
                String idParam = request.getParameter("id");
                if (idParam == null) {
                    response.sendRedirect("Liste.php");
                    return;
                }

                int idMod;
                try {
                    idMod = Integer.parseInt(idParam);
                } catch (NumberFormatException e) {
                    response.sendRedirect("Liste.php");
                    return;
                }

                if ("POST".equals(request.getMethod())) {
                    try {
                        String nom = request.getParameter("nom");
                        String prenom = request.getParameter("prenom");
                        int age = Integer.parseInt(request.getParameter("age"));
                        model.modifierClient(idMod, nom, prenom, age);
                        response.sendRedirect("Liste.php");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        request.setAttribute("client", model.getClientById(idMod));
                        request.getRequestDispatcher("Modifier.jsp").forward(request, response);
                    }
                } else {
                    Client client = model.getClientById(idMod);
                    if (client == null) {
                        response.sendRedirect("Liste.php");
                    } else {
                        request.setAttribute("client", client);
                        request.getRequestDispatcher("Modifier.jsp").forward(request, response);
                    }
                }
                break;

            case "/Supprimer.php":
                String idSupParam = request.getParameter("id");
                if (idSupParam != null) {
                    try {
                        int idSup = Integer.parseInt(idSupParam);
                        model.supprimerClient(idSup);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                response.sendRedirect("Liste.php");
                break;

            default:
                response.sendRedirect("404.html");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


