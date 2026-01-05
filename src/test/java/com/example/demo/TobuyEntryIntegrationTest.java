package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class TobuyEntryIntegrationTest {

    @Test
    void contextLoads() {
        // Dieser Test prüft:
        // - Spring Context startet
        // - Controller, Service, Repository werden geladen
        // - JPA + H2 funktionieren zusammen
    }
}
