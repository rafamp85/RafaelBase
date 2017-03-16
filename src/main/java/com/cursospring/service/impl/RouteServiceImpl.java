package com.cursospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cursospring.component.RouteConverter;
import com.cursospring.entity.Route;
import com.cursospring.model.RouteModel;
import com.cursospring.respository.RouteRepository;
import com.cursospring.service.RouteService;

@Service("routeServiceImpl")
public class RouteServiceImpl implements RouteService {

	@Autowired
	@Qualifier("routeRepository")
	RouteRepository routeRepository;
	
	@Autowired
	@Qualifier("routeConverter")
	RouteConverter routeConverter;
	
	
	@Override
	public RouteModel addRoute(RouteModel routeModel) {
		Route route = routeRepository.save(routeConverter.convertRouteModel2Route(routeModel));
		return routeConverter.convertRoute2RouteModel(route);
	}

	@Override
	public List<RouteModel> listAllRoutes() {
		List<Route> routes = routeRepository.findAll();
		List<RouteModel> routesModel = new ArrayList<>();
 		
		for(Route route : routes){
			routesModel.add(routeConverter.convertRoute2RouteModel(route));
		}
		
		return routesModel;
	}

	@Override
	public Route findRouteById(int id) {
		return routeRepository.findByIdroute(id);
	}

	@Override
	public RouteModel findRouteModelById(int id) {
		Route route = routeRepository.findByIdroute(id);
		
		return routeConverter.convertRoute2RouteModel(route);
	}

	@Override
	public void removeRoute(int id) {
		Route route = routeRepository.findByIdroute(id);
		
		if(null != route){
			routeRepository.delete(route);
		}
	}

}
