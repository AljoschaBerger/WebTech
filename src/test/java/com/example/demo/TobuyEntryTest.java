package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TobuyEntryTest {

    @Test
    void togglePurchased_flipsValue() {
        TobuyEntry entry = new TobuyEntry("Milk");
        boolean before = entry.isPurchased();

        entry.togglePurchased();

        assertNotEquals(before, entry.isPurchased());
    }

    @Test
    void toggleFavorite_flipsValue() {
        TobuyEntry entry = new TobuyEntry("Bread");
        boolean before = entry.isFavorite();

        entry.toggleFavorite();

        assertNotEquals(before, entry.isFavorite());
    }
}

