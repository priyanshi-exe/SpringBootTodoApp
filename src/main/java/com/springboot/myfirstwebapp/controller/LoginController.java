package com.springboot.myfirstwebapp.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
//	// GET, POST
//	@RequestMapping("/login")
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}

//	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}



	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
//			logger.debug("Request param is {}", name);
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials! Please try again");
		return "login";
	}
	
}