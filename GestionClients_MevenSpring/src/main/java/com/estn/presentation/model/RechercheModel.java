package com.estn.presentation.model;

import java.util.ArrayList;
import java.util.List;

import com.estn.dao.entities.Client;

public class RechercheModel {
	private List<Client> clients = new ArrayList<Client>();
	private String motCle;
	
	
	public RechercheModel() {
		

	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public String getMotCle() {
		return motCle;
	}


	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

}
