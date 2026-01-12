package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TobuyEntryRepository extends JpaRepository<TobuyEntry, Long> {
    List<TobuyEntry> findByFavoriteTrue();

}

