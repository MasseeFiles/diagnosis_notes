package com.medilabo.diagnosis_notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *L'objet Note contient en attribut un customId qui permet de lier plusieurs
 * notes à un id unique (donc un patient unique) dans la base MongoDb - sa valeur est determinée en fonction
 * du patientId au niveau du controller.
 * @see com.medilabo.diagnosis_notes.controller.NoteController
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private Long customId;
    private String noteField;

    public Note(Long customId, String noteField) {
        this.customId = customId;
        this.noteField = noteField;
    }
}


