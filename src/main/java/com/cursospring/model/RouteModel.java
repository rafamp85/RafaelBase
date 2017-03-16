package com.cursospring.model;

import com.cursospring.entity.Client;

public class RouteModel {

	private int idroute;
	private String routename;
	private String routedescription;
	private Client client;

	public RouteModel() {
	}

	public RouteModel(int idroute, String routename, String routedescription, Client client) {
		super();
		this.idroute = idroute;
		this.routename = routename;
		this.routedescription = routedescription;
		this.client = client;
	}

	public int getIdroute() {
		return idroute;
	}

	public void setIdroute(int idroute) {
		this.idroute = idroute;
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public String getRoutedescription() {
		return routedescription;
	}

	public void setRoutedescription(String routedescription) {
		this.routedescription = routedescription;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "RouteModel [idRoute=" + idroute + ", routename=" + routename + ", routedescription=" + routedescription
				+ ", client=" + client + "]";
	}

}
