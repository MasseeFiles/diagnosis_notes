package com.medilabo.diagnosis_notes.repository;

import com.medilabo.diagnosis_notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, Long> {
    @Query("{ 'customId': ?0 }")    //JSON-based query string - field : value
    List<Note> findByCustomId(Long customId);
}


