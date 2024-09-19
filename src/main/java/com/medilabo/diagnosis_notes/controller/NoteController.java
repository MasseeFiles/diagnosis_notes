package com.medilabo.diagnosis_notes.controller;

import com.medilabo.diagnosis_notes.model.Note;
import com.medilabo.diagnosis_notes.service.NoteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private static final Logger logger = LogManager.getLogger("NoteController");

    @Autowired
    private NoteService noteService;

    @GetMapping("/{id}")       //id correspond au patientId transmis par la requete du microservice diagnosisview
    public List<Note> getAllNoteByPatientId(@PathVariable Long id) {

        logger.info("Requete pour obtenir la liste de toutes les notes d'un patient");

        return noteService.findNoteByPatientId(id);
    }

    @PostMapping("/{id}")
    public void createNote(
            @PathVariable("id") Long id,
            @RequestBody String noteField
    ) {

        logger.info("Requete pour persister une note en base");

        Note noteToCreate = new Note();
        noteToCreate.setCustomId(id);
        noteToCreate.setNoteField(noteField);

        noteService.createNote(noteToCreate);
    }

}
