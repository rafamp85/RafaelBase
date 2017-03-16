package com.cursospring.respository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.entity.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Serializable> {

	public abstract Client findByIdclient(int id);
	
}
