package com.cursospring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cursospring.constant.ViewConstant;
import com.cursospring.model.RouteModel;
import com.cursospring.service.RouteService;

@Controller
@RequestMapping("/routes")
public class RouteController {

	private static final Log LOG = LogFactory.getLog(RouteController.class);
	
	@Autowired
	@Qualifier("routeServiceImpl")
	RouteService routeService;
	
	@GetMapping("/cancel")
	public String cancel(){
		return "redirect:/routes/showroutes";
	}
	
	
	@GetMapping("/routeform")
	public String redirectRouteForm(@RequestParam(name="id", required = false) int id,
			Model model){
		
		RouteModel routeModel = new RouteModel();
		
		if(id != 0){
			routeModel = routeService.findRouteModelById(id);
		}
		
		model.addAttribute("routeModel", routeModel);
		return ViewConstant.ROUTE_FORM;
	}
	
	
	@PostMapping("/addroute")
	public String addRoute(@ModelAttribute(name="routeModel") RouteModel routeModel, Model model){
		LOG.info("METHOD: addroute -- PARAMS:" + routeModel.toString());
		
		if(null != routeService.addRoute(routeModel)){
			model.addAttribute("result", 1);
		}
		else{
			model.addAttribute("result", 0);
		}
		
		return "redirect:/routes/showroutes";
	}
	
	
	@GetMapping("/showroutes")
	public ModelAndView showClients(){
		ModelAndView mav = new ModelAndView(ViewConstant.ROUTES);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		mav.addObject("username", user.getUsername());
		mav.addObject("routes", routeService.listAllRoutes());
		
		return mav;
	}
	
	@GetMapping("/removeroute")
	public ModelAndView removeRoute(@RequestParam(name="id", required = true) int id){
		routeService.removeRoute(id);
		
		return showClients();
	}
	
}
