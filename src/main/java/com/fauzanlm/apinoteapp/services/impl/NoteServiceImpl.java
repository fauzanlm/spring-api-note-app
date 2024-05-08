package com.fauzanlm.apinoteapp.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.fauzanlm.apinoteapp.model.Note;
import com.fauzanlm.apinoteapp.model.dto.NoteDTO;
import com.fauzanlm.apinoteapp.repository.NoteRepository;
import com.fauzanlm.apinoteapp.services.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	@Autowired
	private NoteRepository repo;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public List<Note> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Note createNote(NoteDTO data) {
		// TODO Auto-generated method stub
		Note dataResult = mapper.map(data, Note.class);
		return repo.save(dataResult);
	}
	@Override
	public Note updateNote(NoteDTO data, Integer id) {
		// TODO Auto-generated method stub
//		System.out.println(id + data.toString());
		Note dbRow = repo.findById(id).get();
		Note dataResult = mapper.map(data, dbRow.getClass());
		dataResult.setId(id);
		return repo.save(dataResult);
	}
	@Override
	public void deleteNote(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
