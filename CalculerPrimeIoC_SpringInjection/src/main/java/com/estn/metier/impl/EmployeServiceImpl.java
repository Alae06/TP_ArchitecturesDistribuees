package com.estn.metier.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import com.estn.dao.*;
import com.estn.dao.entities.Employe;
import com.estn.dao.impl.EmployeDaoImpl;
import com.estn.metier.IEmployeService;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EmployeServiceImpl implements IEmployeService{
	@Autowired
	private IEmployeDao dao;
	
	
	
	public void setDao(IEmployeDao dao) {
		this.dao = dao;
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
