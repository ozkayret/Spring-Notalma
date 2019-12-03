package com.oguzkurtcebe.notalma;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oguzkurtcebe.entity.Note;
import com.oguzkurtcebe.service.NoteService;

@Controller
public class HomeController {

	@Autowired
	private NoteService noteservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {

		System.out.println(req.getRemoteAddr());
		model.addAttribute("serverTime", "/");

		return "index";
	}

	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String home(Model model) {
		/* Note note=new Note();
		 note.setTitle("Merhaba");
		 note.setContent("Nasýlsýnýz");
		 note.setUser_id(1l);
		 noteservice.createNote(note);*/
	/*for (Note note : noteservice.getAll()) {
			System.out.println(note.getContent());

		}*/
		return "detail";
	}
	@RequestMapping(value = "/ekle", method = RequestMethod.GET)
	public String ekle(Model model) {

		return "addNote";
	}
	
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
		public ResponseEntity<String>addNote(@RequestBody Note note, HttpServletRequest request) {
	
			System.out.println(note.toString());
			noteservice.createNote(note,request);
			return new ResponseEntity<>("OK",HttpStatus.CREATED);
		}
	
	
	
	@RequestMapping(value = "/getNotes", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>>getNotes(@RequestBody Note note, HttpServletRequest request) {

		System.out.println(note.toString());
		
		return new ResponseEntity<>(noteservice.getAll(1l),HttpStatus.CREATED);
	}
	
	
	
	

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {

		return "error_404";
	}
}
