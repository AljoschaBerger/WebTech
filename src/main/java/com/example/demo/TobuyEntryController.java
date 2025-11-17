package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class TobuyEntryController {

    private final TobuyEntryRepository repository;

    public TobuyEntryController(TobuyEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<TobuyEntry> getEntries() {
        return repository.findAll();
    }

    @PostMapping
    public TobuyEntry createEntry(@RequestBody TobuyEntry entry) {
        return repository.save(entry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        repository.deleteById(id);
    }
}



