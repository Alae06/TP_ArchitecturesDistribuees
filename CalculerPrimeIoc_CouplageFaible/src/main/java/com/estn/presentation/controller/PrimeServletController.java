package com.estn.presentation.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

import com.estn.dao.IEmployeDao;
import com.estn.dao.impl.EmployeDaoImpl;
import com.estn.metier.IEmployeService;
import com.estn.metier.impl.EmployeServiceImpl;
import com.estn.metier.utils.InjectionClass;
import com.estn.presentation.model.PrimeModel;


@WebServlet("*.php")
public class PrimeServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IEmployeService metier; 
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		metier = InjectionClass.getInstance();
		
		//------------------------injection statique-----------------------------
		//IEmployeDao dao = new EmployeDaoImpl(); 
		//metier = new EmployeServiceImpl();
		//metier.setDao(dao);
		
		//-----------------------------------------------------------------------
		
		
		//------------------------injection dynamique-----------------------------
		
        try {
		ClassLoader cl = Thread .currentThread().getContextClassLoader();
		InputStream is = cl.getResourceAsStream("config.txt");
		
		Scanner s = new Scanner(is);
		
		//la meme chose que cette ligne (--IEmployeDao dao = new EmployeDaoImpl();--) 
		String daoClassename = s.nextLine();
		System.out.println(daoClassename);
		Class cDao = Class.forName(daoClassename);
		IEmployeDao dao = (IEmployeDao)cDao.getDeclaredConstructor().newInstance();


		//la meme chose que cette ligne (--metier = new EmployeServiceImpl();--)
		String metierClassename = s.nextLine();
		System.out.println(metierClassename);
		Class cMetier = Class.forName(metierClassename);
		metier = (IEmployeService)cMetier.getDeclaredConstructor().newInstance();
		
		//la meme chose que cette ligne (--metier.setDao(dao);--)
		Method m = cMetier.getMethod("setDao", IEmployeDao.class);
		m.invoke(metier, dao);

		
		
		
		
		
        }catch (Exception e) {
        	e.printStackTrace();
		}
		
		
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

