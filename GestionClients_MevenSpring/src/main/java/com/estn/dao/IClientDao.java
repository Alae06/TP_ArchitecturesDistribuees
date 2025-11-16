package com.estn.dao;

import java.util.List;

import com.estn.dao.entities.Client;

public interface IClientDao {
	
	public void saveClient(Client client);
	public void updateClient(Client client,Long id);
	public void deleteClient(Long id);
	public Client getClient(Long id);
	public List<Client> getClients();
	public List<Client> searchClientByName(String motCle);

}
