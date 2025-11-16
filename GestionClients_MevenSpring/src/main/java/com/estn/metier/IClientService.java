package com.estn.metier;

import java.util.List;

import com.estn.dao.entities.Client;

public interface IClientService {
	public void enregistrerClient(Client client);
	public void modifierClient(Client client,Long id);
	public void supprimerClient(Long id);
	public Client recupererClient(Long id);
	public List<Client> recupererTsClients();
	public List<Client> rechercherClientParNom(String motCle);


}
