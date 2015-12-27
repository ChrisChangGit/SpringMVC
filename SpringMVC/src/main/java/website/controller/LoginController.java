package website.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import website.model.bean.LoginBean;
import website.validator.LoginValidator;

@Controller
public class LoginController {
	
	@Autowired
	private LoginValidator loginValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}
	
	@RequestMapping(value = "/")
	public ModelAndView createLoginForm() {
		return new ModelAndView("login", "login", new LoginBean());
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") @Valid LoginBean loginBean, 
			BindingResult result, SessionStatus status) {
		
		if(result.hasErrors()) {
			return new ModelAndView("login");
		}
		
		return new ModelAndView("index");
	}
	
}
