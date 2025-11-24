package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tobuys")
@CrossOrigin(origins = "*") // wenn CORSConfig schon existiert, kannst du diese Zeile auch weglassen
public class TobuyEntryController {

    private final TobuyEntryRepository repository;

    public TobuyEntryController(TobuyEntryRepository repository) {
        this.repository = repository;
    }


    // Alle Einträge holen
    @CrossOrigin
    @GetMapping
    public List<TobuyEntry> getEntries() {
        return repository.findAll();
    }

    // Neuen Eintrag anlegen
    @PostMapping
    public TobuyEntry createEntry(@RequestBody TobuyEntry entry) {
        return repository.save(entry);
    }

    // Eintrag löschen
    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔥 M4: purchased toggeln
    @PutMapping("/{id}/togglePurchased")
    public TobuyEntry togglePurchased(@PathVariable Long id) {
        TobuyEntry entry = repository.findById(id).orElseThrow();
        entry.togglePurchased();         // Methode in TobuyEntry
        return repository.save(entry);
    }

    // 🔥 M4: favorite toggeln
    @PutMapping("/{id}/toggleFavorite")
    public TobuyEntry toggleFavorite(@PathVariable Long id) {
        TobuyEntry entry = repository.findById(id).orElseThrow();
        entry.toggleFavorite();          // Methode in TobuyEntry
        return repository.save(entry);
    }
}

