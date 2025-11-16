
package com.estn.dao.utilis;

import com.estn.dao.IClientDao;
import com.estn.dao.entities.Client;
import com.estn.dao.impl.ClientDaoImpl;

public class TestDao {
	public static void main(String[] args) {
		
		IClientDao dao = new ClientDaoImpl();
		Client client = dao.getClient(new Long(1));
		
		client.setAge(20);
		dao.updateClient(client, new Long(1));
		System.out.println(dao.getClient(new Long(1)));
	}

}
