package com.cursospring.component;

import org.springframework.stereotype.Component;

import com.cursospring.entity.Client;
import com.cursospring.model.ClientModel;

@Component("clientConverter")
public class ClientConverter {

	public Client convertClientModel2Client(ClientModel clientModel){
		Client client = new Client();
		
		client.setAddress(clientModel.getAddress());
		client.setClientname(clientModel.getClientname());
		client.setId(clientModel.getId());
		client.setRoute(clientModel.getRoute());
		client.setTelephone(clientModel.getTelephone());
		
		return client;
	}
	
	
	public ClientModel convertClient2ClientModel(Client client){
		ClientModel clientModel = new ClientModel();
		
		clientModel.setAddress(client.getAddress());
		clientModel.setClientname(client.getClientname());
		clientModel.setId(client.getId());
		clientModel.setRoute(client.getRoute());
		clientModel.setTelephone(client.getTelephone());
		
		return clientModel;
	}
}
