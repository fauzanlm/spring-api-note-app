package com.fauzanlm.apinoteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fauzanlm.apinoteapp.model.Note;
import com.fauzanlm.apinoteapp.model.dto.NoteDTO;
import com.fauzanlm.apinoteapp.services.NoteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/notes")
public class NoteController {
	
	@Autowired
	private NoteService service;
	
	@GetMapping
	public ResponseEntity<List<Note>> get() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping("/post")
	public Note createNote(@RequestBody NoteDTO data) {
		return service.createNote(data);
	}
	
	@PutMapping("/post/{id}")
	public Note updateNote(@RequestBody NoteDTO data, @PathVariable("id") Integer id) {
		return service.updateNote(data, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteNote(@RequestParam("id") Integer id) {
		service.deleteNote(id);
	}
}

