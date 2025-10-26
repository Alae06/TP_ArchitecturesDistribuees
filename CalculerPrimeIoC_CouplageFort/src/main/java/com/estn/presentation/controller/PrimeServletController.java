package com.estn.presentation.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.estn.dao.Employe;
import com.estn.metier.EmployeServiceImpl;
import com.estn.presentation.model.PrimeModel;


@WebServlet("*.php")
public class PrimeServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeServiceImpl metier; 
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		metier = new EmployeServiceImpl();//couplage fort
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		if ("/acceuil.php".equals(path)) {
			request.getRequestDispatcher("vues/index.html").forward(request, response);
		}else if ("/calculer.php".equals(path)) {
			
	        int id = Integer.parseInt(request.getParameter("id_employe"));
	        Map<String,Object> map = metier.calculerPrime(id);
			
		        //---------------------------PRESENTATION-----------------------------
		        
		        PrimeModel primeModel = new PrimeModel();
		        primeModel.setNom((String)map.get("nom"));
		        primeModel.setPrenom((String)map.get("prenom"));
		        primeModel.setPrime((double)map.get("prime"));
		        
		        request.setAttribute("pm", primeModel);
		        request.getRequestDispatcher("vues/resultat.jsp").forward(request, response);
		        
		        //--------------------------------------------------------------------

		}else {
			request.getRequestDispatcher("vues/404.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

