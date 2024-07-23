package com.medilabo.diagnosis_notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private Long customId;      //permet d'attribuer plusieurs noteField à un id dans la base MongoDb - doit correspondre au patientID
    private String noteField;

    public Note(Long customId, String noteField) {
        this.customId = customId;
        this.noteField = noteField;
    }
}


