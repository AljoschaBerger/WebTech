package com.example.demo;

import java.time.Instant;

public class TobuyEntry {
    private long id;
    private String name;
    private boolean purchased;
    private boolean favorite;
    private Instant lastUsedAt;

    public TobuyEntry() {

    }

    public TobuyEntry(long id, String name) {
        this.id = id;
        this.name = name;
        this.lastUsedAt = Instant.now();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public boolean isPurchased() {
        return purchased;
    }
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
        this.lastUsedAt = Instant.now();
    }

    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
        this.lastUsedAt = Instant.now();
    }

    public Instant getLastUsedAt() {
        return lastUsedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void togglePurchased() {
        this.purchased = !this.purchased;
        this.lastUsedAt = Instant.now();
    }

    public void toggleFavorite() {
        this.favorite = !this.favorite;
        this.lastUsedAt = Instant.now();
    }
}
