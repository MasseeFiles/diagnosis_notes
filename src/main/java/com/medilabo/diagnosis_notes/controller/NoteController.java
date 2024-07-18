package com.medilabo.diagnosis_notes.controller;

import com.medilabo.diagnosis_notes.model.Note;
import com.medilabo.diagnosis_notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")        //id correspond au patientId transmis par la requete du microservice diagnosisview
    public List<Note> getAllByCustomId(@PathVariable Long id) {
        return noteService.findAllByCustomId(id);
    }

    @PostMapping("")
    public void createNote(@RequestBody Note noteToCreate) {
        noteService.createNote(noteToCreate);
    }
}
