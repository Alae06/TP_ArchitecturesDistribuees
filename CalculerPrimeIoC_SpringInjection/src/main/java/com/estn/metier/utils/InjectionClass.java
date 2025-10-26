package com.estn.metier.utils;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.estn.dao.IEmployeDao;
import com.estn.metier.IEmployeService;

public class InjectionClass {
	/*private static IEmployeService metier;
	
	static {
		
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
	private InjectionClass() {

	}
	
	public static IEmployeService getInstance() {
		return metier;
		
	} */
}
