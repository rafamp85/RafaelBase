package com.cursospring.model;

public class ClientModel {

	private int idclient;
	private String clientname;
	private String address;
	private String telephone;
	private int idroute;
	private RouteModel route;

	public ClientModel() {
	}

	public ClientModel(int idclient, String clientname, String address, String telephone, int idroute,
			RouteModel route) {
		super();
		this.idclient = idclient;
		this.clientname = clientname;
		this.address = address;
		this.telephone = telephone;
		this.idroute = idroute;
		this.route = route;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
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

	public int getIdroute() {
		return idroute;
	}

	public void setIdroute(int idroute) {
		this.idroute = idroute;
	}

	public RouteModel getRoute() {
		return route;
	}

	public void setRoute(RouteModel route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "ClientModel [idclient=" + idclient + ", clientname=" + clientname + ", address=" + address
				+ ", telephone=" + telephone + ", idroute=" + idroute + ", route=" + route + "]";
	}



}
