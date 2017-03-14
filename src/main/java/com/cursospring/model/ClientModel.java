package com.cursospring.model;

import com.cursospring.entity.Route;

public class ClientModel {

	private int id;
	private String clientname;
	private String address;
	private String telephone;
	private Route route;

	public ClientModel() {
	}

	public ClientModel(int id, String clientname, String address, String telephone, Route route) {
		super();
		this.id = id;
		this.clientname = clientname;
		this.address = address;
		this.telephone = telephone;
		this.route = route;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "ClientModel [id=" + id + ", clientname=" + clientname + ", address=" + address + ", telephone="
				+ telephone + ", route=" + route + "]";
	}

}
