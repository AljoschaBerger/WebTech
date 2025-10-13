package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TobuyEntryController {

    @GetMapping("/tobuys")
    public List<TobuyEntry> getTobuyEntries() {
        return List.of(new TobuyEntry("M1"), new TobuyEntry("M2"), new TobuyEntry("M3"));
    }

}
