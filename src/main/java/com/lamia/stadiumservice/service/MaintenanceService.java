package com.lamia.stadiumservice.service;

import com.lamia.stadiumservice.repository.MaintenanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    private final Logger log = LoggerFactory.getLogger(MaintenanceService.class);
    private final MaintenanceRepository repository;
    private final MenuMasterService menuMasterService;

    public MaintenanceService(MaintenanceRepository repository, MenuMasterService menuMasterService) {
        this.repository = repository;
        this.menuMasterService = menuMasterService;
    }
}
