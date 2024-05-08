package com.fauzanlm.apinoteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fauzanlm.apinoteapp.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
  
}