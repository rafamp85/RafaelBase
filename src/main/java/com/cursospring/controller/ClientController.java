package com.cursospring.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cursospring.constant.ViewConstant;
import com.cursospring.model.ClientModel;
import com.cursospring.model.RouteModel;
import com.cursospring.service.ClientService;
import com.cursospring.service.RouteService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	private static final Log LOG = LogFactory.getLog(ClientController.class);
	
	@Autowired
	@Qualifier("clientServiceImpl")
	private ClientService clientService;
	
	@Autowired
	@Qualifier("routeServiceImpl")
	RouteService routeService;
	
	
	@GetMapping("/cancel")
	public String cancel(){
		return "redirect:/clients/showclients";
	}
	
	
	@GetMapping("/clientform")
	public String redirectClientForm(@RequestParam(name="id", required=false) int id,
			Model model){
		
		ClientModel clientModel = new ClientModel();
		
		if(id != 0){
			clientModel = clientService.findClientModelById(id);
		}
		model.addAttribute("clientModel", clientModel);
		model.addAttribute("routes", routeService.listAllRoutes());
		return ViewConstant.CLIENT_FORM;
	}
	
	@PostMapping("/addclient")
	public String addClient(@Valid @ModelAttribute(name="clientModel") ClientModel clientModel, 
			BindingResult bindingResult,
			Model model ){
		
		LOG.info("METHOD: addclient -- PARAMS:" + clientModel.toString());

//		if(bindingResult.hasErrors()){
//			LOG.info("METHOD: addclient -- PARAMS ERRORS:" + clientModel.toString());
//			return "redirect:/clients/clientform?id=0";
//		}
		
		RouteModel routeModel = routeService.findRouteModelById(clientModel.getIdroute());
		clientModel.setRoute(routeModel);
		
		if(null != clientService.addClient(clientModel)){
			model.addAttribute("result", 1);
		}
		else{
			model.addAttribute("result", 0);
		}
		
		return "redirect:/clients/showclients";
	}
	
	
	@GetMapping("/showclients")
	public ModelAndView showClients(){
		ModelAndView mav = new ModelAndView(ViewConstant.CLIENTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		mav.addObject("username", user.getUsername());
		mav.addObject("clients", clientService.listAllClients());
		
		return mav;
	}
	
	
	@GetMapping("/removeclient")
	public ModelAndView removeClient(@RequestParam(name="id", required=true) int id){
		clientService.removeClient(id);
		
		return showClients();
	}
	
}
