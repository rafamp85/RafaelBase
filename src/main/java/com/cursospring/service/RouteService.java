package com.cursospring.service;

import java.util.List;

import com.cursospring.entity.Route;
import com.cursospring.model.RouteModel;

public interface RouteService {

	public abstract RouteModel addRoute(RouteModel contactModel);
	
	public abstract List<RouteModel> listAllRoutes();
	
	public abstract Route findRouteById(int id);
	
	public abstract RouteModel findRouteModelById(int id);
	
	public abstract void removeRoute(int id);
}
