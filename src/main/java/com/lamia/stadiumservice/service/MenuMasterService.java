package com.lamia.stadiumservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lamia.stadiumservice.model.MenuMaster;
import com.lamia.stadiumservice.repository.MenuMasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuMasterService {

    private final Logger log = LoggerFactory.getLogger(MenuMasterService.class);
    private final MenuMasterRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public MenuMasterService(MenuMasterRepository repository) {
        this.repository = repository;
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public MenuMaster getMenuByPath(String path) throws JsonProcessingException {
        log.info("Entering method getMenuByPath on class " + MenuMasterService.class.getName() + " at " + System.currentTimeMillis());
        Optional<MenuMaster> dataMenu = repository.findByPath(path);
        MenuMaster menuMaster = new MenuMaster();

        dataMenu.ifPresentOrElse(menu -> {
            menuMaster.setMenuMasterId(menu.getMenuMasterId());
            menuMaster.setMenuGroupName(menu.getMenuGroupName());
            menuMaster.setMenuName(menu.getMenuName());
            menuMaster.setPath(menu.getPath());
            menuMaster.setPosition(menu.getPosition());
        }, () -> {});

        log.info("Leaving method getMenuByPath on class " + MenuMasterService.class.getName() + " at " + System.currentTimeMillis());
        log.info(mapper.writeValueAsString(menuMaster));
        return menuMaster;
    }
}
