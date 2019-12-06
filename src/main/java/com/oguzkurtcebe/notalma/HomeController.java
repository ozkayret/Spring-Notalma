package com.oguzkurtcebe.notalma;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/detay/{id}", method = RequestMethod.GET)
	public String home(@PathVariable("id") Long id , Model model) {
	//	System.out.println(id);
		model.addAttribute("id",id);
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
	
	@RequestMapping(value = "/updateNote", method = RequestMethod.POST)
	public ResponseEntity<String>updateNote(@RequestBody Note note, HttpServletRequest request) {
        Note oldNote=noteservice.getNoteFindById(note.getId());
        oldNote.setTitle(note.getTitle());
        oldNote.setContent(note.getContent());
        
        noteservice.updateNote(oldNote, request);
        return new ResponseEntity<>("OK",HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/deleteNote", method = RequestMethod.POST)
	public ResponseEntity<String>deleteNote(@RequestBody Note note, HttpServletRequest request) {
        Note oldNote=noteservice.getNoteFindById(note.getId());
       
        noteservice.deleteNote(oldNote, request);
        return new ResponseEntity<>("OK",HttpStatus.CREATED);
		
	}
	@RequestMapping(value = "/getNotes", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>>getNotes(HttpServletRequest request) {

		System.out.println("sonuc:"+noteservice.getAll(1l).toString());
		
		return new ResponseEntity<>(noteservice.getAll(1l),HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/getNote", method = RequestMethod.POST)
	public ResponseEntity<Note>getNotes(@RequestBody String id,HttpServletRequest request) {


	System.out.println(id);
		
		return new ResponseEntity<>(noteservice.getNoteFindById(Long.parseLong(id)),HttpStatus.CREATED);
	
		
	}
	
	
	

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {

		return "error_404";
	}
}
