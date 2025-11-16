package com.estn.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estn.dao.IClientDao;
import com.estn.dao.entities.Client;
import com.estn.metier.IClientService;

@Component
public class ClientServiceImpl implements IClientService{
	
	 @Autowired
	private IClientDao dao;
	

	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	@Override
	public void enregistrerClient(Client client) {
		
		dao.saveClient(client);
	}

	@Override
	public void modifierClient(Client client, Long id) {
		dao.updateClient(client, id);
		
	}

	@Override
	public void supprimerClient(Long id) {
		dao.deleteClient(id);
		
	}

	@Override
	public Client recupererClient(Long id) {
		
		return dao.getClient(id);
	}

	@Override
	public List<Client> recupererTsClients() {
		
		return dao.getClients();
	}

	@Override
	public List<Client> rechercherClientParNom(String motCle) {
		
		return dao.searchClientByName(motCle);
	}

}
