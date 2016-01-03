package website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/titles")
public class TitlesController {
	
	@RequestMapping(value = "/header")
	public ModelAndView getHeader(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/titles/header");
	}
	
	@RequestMapping(value = "/resource")
	public ModelAndView getResource(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/titles/resource");
	}
}
