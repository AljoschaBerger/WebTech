package com.example.demo;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class TobuyEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean purchased;
    private boolean favorite;
    private Instant lastUsedAt;

    public TobuyEntry() {
        this.lastUsedAt = Instant.now();
        this.purchased = false;
        this.favorite = false;
    }

    public TobuyEntry(String name) {
        this.name = name;
        this.purchased = false;
        this.favorite = false;
        this.lastUsedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.lastUsedAt = Instant.now();
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

    // 🔥 M4: Toggle purchased
    public void togglePurchased() {
        this.purchased = !this.purchased;
        this.lastUsedAt = Instant.now();
    }

    // 🔥 M4: Toggle favorite
    public void toggleFavorite() {
        this.favorite = !this.favorite;
        this.lastUsedAt = Instant.now();
    }
}


