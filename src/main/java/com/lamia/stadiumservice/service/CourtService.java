package com.lamia.stadiumservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lamia.stadiumservice.repository.CourtRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CourtService {

    private final Logger log = LoggerFactory.getLogger(CourtService.class);
    private final CourtRepository repository;
    private final MaintenanceService maintenanceService;
    private final MenuMasterService menuMasterService;
    private final ObjectMapper mapper = new ObjectMapper();

    public CourtService(CourtRepository repository, MaintenanceService maintenanceService, MenuMasterService menuMasterService) {
        this.repository = repository;
        this.maintenanceService = maintenanceService;
        this.menuMasterService = menuMasterService;
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
}
