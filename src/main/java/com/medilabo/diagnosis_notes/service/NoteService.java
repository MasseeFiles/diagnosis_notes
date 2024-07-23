package com.medilabo.diagnosis_notes.service;

import com.medilabo.diagnosis_notes.model.Note;
import com.medilabo.diagnosis_notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findNoteByPatientId(Long customId) {       //customId permet d'avoir en base plusieurs notes liées à un Id
        return noteRepository.findNoteByCustomId(customId);
    }

    public void createNote(Note noteToSave) {
        noteRepository.save(noteToSave);
    }

}
