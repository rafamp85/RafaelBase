package com.cursospring.respository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.entity.Route;

@Repository("routeRepository")
public interface RouteRepository extends JpaRepository<Route, Serializable> {
	
	public abstract Route findById(int id);
	
}
