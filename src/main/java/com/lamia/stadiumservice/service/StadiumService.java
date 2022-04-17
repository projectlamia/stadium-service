package com.lamia.stadiumservice.service;

import com.lamia.stadiumservice.repository.StadiumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {

    private final Logger log = LoggerFactory.getLogger(StadiumService.class);
    private final StadiumRepository repository;
    private final MaintenanceService maintenanceService;
    private final MenuMasterService menuMasterService;

    public StadiumService(StadiumRepository repository, MaintenanceService maintenanceService, MenuMasterService menuMasterService) {
        this.repository = repository;
        this.maintenanceService = maintenanceService;
        this.menuMasterService = menuMasterService;
    }
}
