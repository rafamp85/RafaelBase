package com.cursospring.model;

import com.cursospring.entity.Client;

public class RouteModel {

	private int id;
	private String routename;
	private String route;
	private Client client;

	public RouteModel() {
	}

	public RouteModel(int id, String routename, String route, Client client) {
		super();
		this.id = id;
		this.routename = routename;
		this.route = route;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
