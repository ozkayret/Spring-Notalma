package com.oguzkurtcebe.notalma;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oguzkurtcebe.entity.Note;
import com.oguzkurtcebe.service.NoteService;

@Controller
public class HomeController {

//	@Autowired NoteService noteservice;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {

		System.out.println(req.getRemoteAddr());
		model.addAttribute("serverTime", "/");

		return "index";
	}

	
	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String home(Model model)  {
	//Note note=new Note();
	//note.setTitle("Merhaba");
	//note.setContent("Nasýlsýnýz");
	//note.setUser_id(1l);
	//noteservice.createNote(note);


		return "detail";
	}

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {

		return "error_404";
	}
}
