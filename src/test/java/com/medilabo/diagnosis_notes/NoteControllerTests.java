package com.medilabo.diagnosis_notes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilabo.diagnosis_notes.model.Note;
import com.medilabo.diagnosis_notes.service.NoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class NoteControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Test
    void getAllByCustomId_Ok() throws Exception {
        //GIVEN
        Note[] noteArray = new Note[1];
        noteArray[0] = new Note(1L, 1L, "Le patient déclare qu'il 'se sent très bien' Poids égal ou inférieur au poids recommandé");
        List<Note> noteListTest = new ArrayList<>((Arrays.asList(noteArray)));

        when(noteService.findAllByCustomId(1L)).thenReturn(noteListTest);

        Long idTest = 1L;

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/{id}", idTest)
                )
        //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    void getAllByCustomId_CustomIdNotInDB() throws Exception {
        //GIVEN
        Note[] noteArray = new Note[2];
        noteArray[0] = new Note(1L, 1L, "Le patient déclare qu'il 'se sent très bien' Poids égal ou inférieur au poids recommandé");
        List<Note> noteListTest = new ArrayList<>((Arrays.asList(noteArray)));

        when(noteService.findAllByCustomId(1L)).thenReturn(noteListTest);

        Long idTest = 10L;

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/{id}", idTest)
                )
        //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(jsonPath("$.size()").value(0));
    }

    @Test
    void createNote_Ok() throws Exception {
        //GIVEN
        Note noteToCreateTest = new Note(1L, 1L, "NoteTest");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(noteToCreateTest);

        //WHEN
        mockMvc.perform(MockMvcRequestBuilders
                        .post("")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
        //THEN
                .andExpect(MockMvcResultMatchers
                        .status().isOk());

        Mockito.verify(noteService).createNote(noteToCreateTest);
    }
}
