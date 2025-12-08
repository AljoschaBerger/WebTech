package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToBuyEntryService {

    @Autowired
    TobuyEntryRepository tobuyEntryRepository;

    public TobuyEntry save(TobuyEntry tobuyEntry) {
        return tobuyEntryRepository.save(tobuyEntry);
    }

    public TobuyEntry get(Long id) {
        return tobuyEntryRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }


}
