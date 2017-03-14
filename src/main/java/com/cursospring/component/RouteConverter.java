package com.cursospring.component;

import org.springframework.stereotype.Component;

import com.cursospring.entity.Route;
import com.cursospring.model.RouteModel;

@Component("routeConverter")
public class RouteConverter {

	public Route convertRouteModel2Route(RouteModel routeModel){
		Route route = new Route();
		
		route.setClient(routeModel.getClient());
		route.setId(routeModel.getId());
		route.setRoutename(routeModel.getRoutename());
		route.setRoute(routeModel.getRoute());
		
		return route;
	}
	
	public RouteModel convertRoute2RouteModel(Route route){
		RouteModel routeModel = new RouteModel();
		
		routeModel.setClient(route.getClient());
		routeModel.setId(route.getId());
		routeModel.setRoutename(route.getRoutename());
		routeModel.setRoute(route.getRoute());
		
		return routeModel;
	}
}
