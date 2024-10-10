package com.medilabo.diagnosis_notes.repository;

import com.medilabo.diagnosis_notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * La methode findNoteByCustomId est implementée directement par Spring en fonction de
 * son nom (requete deduite: derived query)
 * L'annotation @Query permet de définir dynamiquement une requete basée sur un format JSON
 * (attribut : customId)
 */
@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    @Query("{ 'customId': ?0 }")
    List<Note> findNoteByCustomId(Long customId);

}


