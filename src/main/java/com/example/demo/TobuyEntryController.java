package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TobuyEntryController {

    @GetMapping("/tobuys")
    public List<TobuyEntry> getTobuyEntries() {
        return List.of(new TobuyEntry(1, "M1"), new TobuyEntry(2, "M2"), new TobuyEntry(3, "M3"));
    }
}

