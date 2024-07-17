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
    private Long id;
    private Long customId;      //permet d'attribuer plusieurs noteField à un id dans la base MongoDb
    private String noteField;
}


