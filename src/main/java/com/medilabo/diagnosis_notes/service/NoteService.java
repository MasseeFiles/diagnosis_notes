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

    public List<Note> findAllByCustomId(Long customId) {
        return noteRepository.findByCustomId(customId);
    }

    public void createNote(Note noteToSave) {
        noteRepository.save(noteToSave);
    }
}
