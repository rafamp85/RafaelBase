package com.cursospring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue
	@Column(name = "idroute")
	private int idroute;

	@Column(name = "routename")
	private String routename;

	@Column(name = "routedescription")
	private String routedescription;

//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "route")
//	private Client client;

	public Route() {
	}

	public Route(int idroute, String routename, String routedescription) {
		super();
		this.idroute = idroute;
		this.routename = routename;
		this.routedescription = routedescription;
//		this.client = client;
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

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}

}
