package com.fauzanlm.apinoteapp.services;

import java.util.List;

import com.fauzanlm.apinoteapp.model.Note;
import com.fauzanlm.apinoteapp.model.dto.NoteDTO;

public interface NoteService {
	List<Note> getAll();
	Note createNote(NoteDTO data);
	Note updateNote(NoteDTO data, Integer id);
	void deleteNote(Integer id);
}
