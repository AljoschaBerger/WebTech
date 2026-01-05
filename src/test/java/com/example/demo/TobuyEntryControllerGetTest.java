package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TobuyEntryController.class)
class TobuyEntryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TobuyEntryRepository repository;

    @MockBean
    private ToBuyEntryService toBuyEntryService;

    // ✅ 1. POST – Eintrag anlegen
    @Test
    void createEntry_returnsSavedEntry() throws Exception {
        TobuyEntry entry = new TobuyEntry("Milk");
        entry.setId(1L);

        when(repository.save(any(TobuyEntry.class))).thenReturn(entry);

        mockMvc.perform(post("/tobuys/toBuyEntry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entry)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Milk"));
    }

    // ✅ 2. DELETE – Eintrag löschen
    @Test
    void deleteEntry_returnsOk() throws Exception {
        doNothing().when(repository).deleteById(1L);

        mockMvc.perform(delete("/tobuys/1"))
                .andExpect(status().isOk());

        verify(repository).deleteById(1L);
    }

    // ✅ 3. PUT – purchased toggeln
    @Test
    void togglePurchased_updatesEntry() throws Exception {
        TobuyEntry entry = new TobuyEntry("Bread");
        entry.setId(1L);
        entry.setPurchased(false);

        when(repository.findById(1L)).thenReturn(Optional.of(entry));
        when(repository.save(any(TobuyEntry.class))).thenReturn(entry);

        mockMvc.perform(put("/tobuys/1/togglePurchased"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.purchased").value(true));
    }

    // ✅ 4. PUT – favorite toggeln
    @Test
    void toggleFavorite_updatesEntry() throws Exception {
        TobuyEntry entry = new TobuyEntry("Cheese");
        entry.setId(2L);
        entry.setFavorite(false);

        when(repository.findById(2L)).thenReturn(Optional.of(entry));
        when(repository.save(any(TobuyEntry.class))).thenReturn(entry);

        mockMvc.perform(put("/tobuys/2/toggleFavorite"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.favorite").value(true));
    }

    // ✅ 5. PUT – Fehler bei unbekannter ID
    @Test
    void togglePurchased_unknownId_throwsException() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        org.junit.jupiter.api.Assertions.assertThrows(
                Exception.class,
                () -> mockMvc.perform(put("/tobuys/99/togglePurchased")).andReturn()
        );
    }

}
