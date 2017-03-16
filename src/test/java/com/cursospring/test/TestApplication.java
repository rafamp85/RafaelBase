package com.cursospring.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.cursospring.model.RouteModel;
import com.cursospring.service.ClientService;
import com.cursospring.service.RouteService;
import com.cursospring.service.impl.ClientServiceImpl;
import com.cursospring.service.impl.RouteServiceImpl;

public class TestApplication {
	
	private static final Log LOG = LogFactory.getLog(TestApplication.class);
	
	ClientService cService = new ClientServiceImpl();
	RouteService rService = new RouteServiceImpl();
	
	@Test
	public void testClient(){
		LOG.info("Iniciando Test");
		
		List<RouteModel> lstRoute = rService.listAllRoutes();
		
		for(RouteModel r : lstRoute){
			System.out.println(r.toString());
		}
		
//		RouteModel routeModel = rService.findRouteModelById(1);
//		LOG.info(routeModel.toString());
//		
//		ClientModel clientModel = new ClientModel();
//		clientModel.setClientname("Cliente X");
//		clientModel.setAddress("Direccion X");
//		clientModel.setTelephone("5544332211");
//		clientModel.setRoute(routeModel);
		
		//service.addClient(clientModel);
		
	}

}
