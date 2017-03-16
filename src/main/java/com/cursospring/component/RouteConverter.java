package com.cursospring.component;

import org.springframework.stereotype.Component;

import com.cursospring.entity.Route;
import com.cursospring.model.RouteModel;

@Component("routeConverter")
public class RouteConverter {

	public Route convertRouteModel2Route(RouteModel routeModel){
		Route route = new Route();
		
//		route.setClient(routeModel.getClient());
		route.setIdroute(routeModel.getIdroute());
		route.setRoutename(routeModel.getRoutename());
		route.setRoutedescription(routeModel.getRoutedescription());
		
		return route;
	}
	
	public RouteModel convertRoute2RouteModel(Route route){
		RouteModel routeModel = new RouteModel();
		
//		routeModel.setClient(route.getClient());
		routeModel.setIdroute(route.getIdroute());
		routeModel.setRoutename(route.getRoutename());
		routeModel.setRoutedescription(route.getRoutedescription());
		
		return routeModel;
	}
}
