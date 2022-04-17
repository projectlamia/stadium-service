package com.lamia.stadiumservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lamia.stadiumservice.repository.FacilityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    private final Logger log = LoggerFactory.getLogger(FacilityService.class);
    private final FacilityRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public FacilityService(FacilityRepository repository) {
        this.repository = repository;
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
}
