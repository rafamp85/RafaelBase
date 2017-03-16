package com.cursospring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cursospring.entity.Client;
import com.cursospring.model.ClientModel;

@Component("clientConverter")
public class ClientConverter {

	@Autowired
	@Qualifier("routeConverter")
	RouteConverter routeConverter;
	
	
	public Client convertClientModel2Client(ClientModel clientModel){
		Client client = new Client();
		
		client.setAddress(clientModel.getAddress());
		client.setClientname(clientModel.getClientname());
		client.setIdclient(clientModel.getIdclient());
		client.setTelephone(clientModel.getTelephone());
		client.setRoute(routeConverter.convertRouteModel2Route(clientModel.getRoute()));
		
		return client;
	}
	
	
	public ClientModel convertClient2ClientModel(Client client){
		ClientModel clientModel = new ClientModel();
		
		clientModel.setAddress(client.getAddress());
		clientModel.setClientname(client.getClientname());
		clientModel.setIdclient(client.getIdclient());
		clientModel.setTelephone(client.getTelephone());
		clientModel.setRoute(routeConverter.convertRoute2RouteModel(client.getRoute()));
		
		return clientModel;
	}
}
