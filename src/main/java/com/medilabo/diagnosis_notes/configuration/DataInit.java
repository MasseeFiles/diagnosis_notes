package com.medilabo.diagnosis_notes.configuration;

import com.medilabo.diagnosis_notes.model.Note;
import com.medilabo.diagnosis_notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInit {
    @Autowired
    NoteRepository noteRepository;

    @Bean
    public DataInit init() {
        Note[] notes = new Note[9];

        notes[0] = new Note(1L, "Le patient déclare qu'il 'se sent très bien' Poids égal ou inférieur au poids recommandé");
        notes[1] = new Note(2L ,"Le patient déclare qu'il ressent beaucoup de stress au travail Il se plaint également que son audition est anormale dernièrement");
        notes[2] = new Note(2L  ,"Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois Il remarque également que son audition continue d'être anormale");
        notes[3] = new Note(3L ,"Le patient déclare qu'il fume depuis peu");
        notes[4] = new Note(3L ,"Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière Il se plaint également de crises d’apnée respiratoire anormales Tests de laboratoire indiquant un taux de cholestérol LDL élevé");
        notes[5] = new Note(4L ,"Le patient déclare qu'il lui est devenu difficile de monter les escaliers Il se plaint également d’être essoufflé Tests de laboratoire indiquant que les anticorps sont élevés Réaction aux médicaments");
        notes[6] = new Note(4L ,"Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps");
        notes[7] = new Note(4L ,"Le patient déclare avoir commencé à fumer depuis peu Hémoglobine A1C supérieure au niveau recommandé");
        notes[8] = new Note(4L,"Taille, Poids, Cholestérol, Vertige et Réaction");

        noteRepository.saveAll(Arrays.asList(notes));

        return new DataInit();
    }
}
