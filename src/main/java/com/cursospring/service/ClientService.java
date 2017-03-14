package com.cursospring.service;

import java.util.List;

import com.cursospring.entity.Client;
import com.cursospring.model.ClientModel;

public interface ClientService {
	
	public abstract ClientModel addClient(ClientModel clientModel);
	
	public abstract List<ClientModel> listAllClients();
	
	public abstract Client findClientById(int id);
	
	public abstract ClientModel findClientModelById(int id);
	
	public abstract void removeClient(int id);

}
