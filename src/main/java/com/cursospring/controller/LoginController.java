package com.cursospring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cursospring.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog("LoginController");
	
	@GetMapping("/login")
	public String showLoginForm( Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout){
		
		LOG.info("METHOD: showLoginForm -- PARAMS: error=" + error + " logout=" + logout );
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		
		return ViewConstant.LOGIN;
	}
	
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck(){
		LOG.info("METHOD: logincheck -- PARAMS:");
		LOG.info("Returning to contacts view");
		//return "redirect:/contacts/showcontacts";
		//return "redirect:/routes/showroutes";
		//return "redirect:/clients/showclients";
		return "redirect:/initpage";
	}
	
	
	@GetMapping("/initpage")
	public ModelAndView showInitPage(){
		ModelAndView mav = new ModelAndView(ViewConstant.INIT_PAGE);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		mav.addObject("username", user.getUsername());
		return mav;
	}
}
