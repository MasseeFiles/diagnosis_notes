package com.medilabo.diagnosis_notes.service;

import com.medilabo.diagnosis_notes.model.Note;
import com.medilabo.diagnosis_notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * La methode findNoteByPatientId passe au repository l'Id du client reçu du controller
 * en tant que customId (attribut de chaque note permettant le lien à un patient unique dans la base MongoDb)
 * @see Note
 */
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findNoteByPatientId(Long customId) {
        return noteRepository.findNoteByCustomId(customId);
    }

    public void createNote(Note noteToSave) {
        noteRepository.save(noteToSave);
    }

}

