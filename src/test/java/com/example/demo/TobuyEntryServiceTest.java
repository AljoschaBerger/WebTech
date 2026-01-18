package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ToBuyEntryServiceTest {

    @Mock
    TobuyEntryRepository repository;

    @InjectMocks
    ToBuyEntryService service;

    @Test
    void save_callsRepository() {
        TobuyEntry entry = new TobuyEntry("Cheese");

        service.save(entry);

        verify(repository).save(entry);
    }

    @Test
    void save_isCalledExactlyOnce() {
        TobuyEntry entry = new TobuyEntry("Milk");

        service.save(entry);

        verify(repository).save(entry);
    }

}

