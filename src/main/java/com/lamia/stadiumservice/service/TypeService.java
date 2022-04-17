package com.lamia.stadiumservice.service;

import com.lamia.stadiumservice.repository.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    private final Logger log = LoggerFactory.getLogger(TypeService.class);
    private final TypeRepository repository;

    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }
}
