package com.estn.dao;

import java.sql.Date;

public class Employe {
	public int id;
	public String nom;
	public String prenom;
	public double salaire;
	public Date d_embauche;
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double prime) {
		this.salaire = prime;
	}
	public Date getEmbauche() {
		return d_embauche;
	}
	public void setEmbauche(Date d_embauche) {
		this.d_embauche = d_embauche;
	}

	 

}
