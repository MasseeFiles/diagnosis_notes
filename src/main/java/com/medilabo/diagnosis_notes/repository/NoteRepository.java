package com.medilabo.diagnosis_notes.repository;

import com.medilabo.diagnosis_notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    @Query("{ 'customId': ?0 }")    //JSON-based query string - field : value
    List<Note> findNoteByCustomId(Long customId);   //derived query (requete deduite) : spring implemente la methode en fonction de son nom (customID)

}


