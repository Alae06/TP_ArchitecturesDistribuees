package com.estn.metier.utilis;

import com.estn.dao.IClientDao;
import com.estn.dao.entities.Client;
import com.estn.dao.impl.ClientDaoImpl;
import com.estn.metier.impl.ClientServiceImpl;

public class TestService {
	public static void main(String[] args) {
		
		IClientDao dao = new ClientDaoImpl();
		ClientServiceImpl metier = new ClientServiceImpl();
		metier.setDao(dao);
		
		Client client = new Client(null,"Aya","Elyoumni",19);
		
		metier.enregistrerClient(client);
		
	}

}
