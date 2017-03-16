package com.cursospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cursospring.component.ClientConverter;
import com.cursospring.entity.Client;
import com.cursospring.model.ClientModel;
import com.cursospring.respository.ClientRepository;
import com.cursospring.service.ClientService;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {

	@Autowired
	@Qualifier("clientRepository")
	ClientRepository clientRepository;
	
	@Autowired
	@Qualifier("clientConverter")
	ClientConverter clientConverter;
	
	@Override
	public ClientModel addClient(ClientModel clientModel) {
		System.out.println("SI llega al Service");
		Client client = clientRepository.save(clientConverter.convertClientModel2Client(clientModel));
		return clientConverter.convertClient2ClientModel(client);
	}

	@Override
	public List<ClientModel> listAllClients() {
		List<Client> clients = clientRepository.findAll();
		List<ClientModel> clientsModel = new ArrayList<>();
		
		for(Client client : clients){
			clientsModel.add(clientConverter.convertClient2ClientModel(client));
		}
		
		return clientsModel;
	}

	@Override
	public Client findClientById(int id) {
		return clientRepository.findByIdclient(id);
	}

	@Override
	public ClientModel findClientModelById(int id) {
		Client client = clientRepository.findByIdclient(id);
		return clientConverter.convertClient2ClientModel(client);
	}

	@Override
	public void removeClient(int id) {
		Client client = clientRepository.findByIdclient(id);
		
		if(null != client){
			clientRepository.delete(client);
		}
	}

}
