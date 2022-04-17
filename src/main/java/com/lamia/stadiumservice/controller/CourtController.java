package com.lamia.stadiumservice.controller;

import com.lamia.stadiumservice.service.CourtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courts")
public class CourtController {

    private final Logger log = LoggerFactory.getLogger(CourtController.class);
    private final CourtService service;

    public CourtController(CourtService service) {
        this.service = service;
    }
}
