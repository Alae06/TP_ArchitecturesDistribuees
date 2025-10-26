package com.estn.metier;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import com.estn.dao.*;
import java.util.Map;

public class EmployeServiceImpl {
	
	private EmployeDaoImpl dao;
	
	public EmployeServiceImpl() {
		dao = new EmployeDaoImpl(); //couplage fort
	}
	
	public Map<String, Object> calculerPrime(long id){
	Map<String, Object> map = new  HashMap<String, Object>();
	Employe e = dao.getEmploye(id);
	
	double prime=0.;
    Period p = Period.between(LocalDate.parse(e.getEmbauche().toString()), LocalDate.now());
    prime = e.getSalaire() + (p.getYears()*500);
    
    map.put("nom", e.getNom());
    map.put("prenom", e.getPrenom());
    map.put("prime", prime);

    
    return map;
	}
	

}
