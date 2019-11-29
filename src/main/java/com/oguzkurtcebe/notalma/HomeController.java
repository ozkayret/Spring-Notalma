package com.oguzkurtcebe.notalma;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
	
		System.out.println(req.getRemoteAddr());
		model.addAttribute("serverTime", "/" );
		
		return "home";
	}
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {
	
		
		
		return "error_404";
	}
}
