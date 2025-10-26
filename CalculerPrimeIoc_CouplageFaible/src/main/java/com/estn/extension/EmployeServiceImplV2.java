package com.estn.extension;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import com.estn.dao.IEmployeDao;
import com.estn.dao.entities.Employe;
import com.estn.metier.IEmployeService;

public class EmployeServiceImplV2 implements IEmployeService{


		private IEmployeDao dao;
		
		
		
		public void setDao(IEmployeDao dao) {
			this.dao = dao;
		}



		public Map<String, Object> calculerPrime(long id){
		Map<String, Object> map = new  HashMap<String, Object>();
		Employe e = dao.getEmploye(id);
		
		double prime=0.;
	    Period p = Period.between(LocalDate.parse(e.getEmbauche().toString()), LocalDate.now());
	    prime = e.getSalaire() + (p.getYears()* 1500);
	    
	    map.put("nom", e.getNom());
	    map.put("prenom", e.getPrenom());
	    map.put("prime", prime);

	    
	    return map;
		}
	}
	


