package com.lamia.stadiumservice.service;

import com.lamia.stadiumservice.repository.MenuMasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MenuMasterService {

    private final Logger log = LoggerFactory.getLogger(MenuMasterService.class);
    private final MenuMasterRepository repository;

    public MenuMasterService(MenuMasterRepository repository) {
        this.repository = repository;
    }
}
