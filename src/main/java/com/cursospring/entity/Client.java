package com.cursospring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
	@Column(name = "idclient")
	private int idclient;

	@Column(name = "clientname")
	private String clientname;

	@Column(name = "address")
	private String address;

	@Column(name = "telephone")
	private String telephone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idroute")
	private Route route;

	public Client() {
	}

	public Client(int idclient, String clientname, String address, String telephone, Route route) {
		super();
		this.idclient = idclient;
		this.clientname = clientname;
		this.address = address;
		this.telephone = telephone;
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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}
