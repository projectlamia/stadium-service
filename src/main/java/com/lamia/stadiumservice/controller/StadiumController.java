package com.lamia.stadiumservice.controller;

import com.lamia.stadiumservice.service.StadiumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final Logger log = LoggerFactory.getLogger(StadiumController.class);
    private final StadiumService service;

    public StadiumController(StadiumService service) {
        this.service = service;
    }
}
