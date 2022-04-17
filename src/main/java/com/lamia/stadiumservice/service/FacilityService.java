package com.lamia.stadiumservice.service;

import com.lamia.stadiumservice.repository.FacilityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    private final Logger log = LoggerFactory.getLogger(FacilityService.class);
    private final FacilityRepository repository;

    public FacilityService(FacilityRepository repository) {
        this.repository = repository;
    }
}
