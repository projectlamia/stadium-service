package com.lamia.stadiumservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lamia.stadiumservice.invocation.MaintenanceInvocation;
import com.lamia.stadiumservice.model.Maintenance;
import com.lamia.stadiumservice.model.MenuMaster;
import com.lamia.stadiumservice.payload.request.MaintenanceRequest;
import com.lamia.stadiumservice.repository.MaintenanceRepository;
import com.lamia.stadiumservice.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    private final Logger log = LoggerFactory.getLogger(MaintenanceService.class);
    private final MaintenanceRepository repository;
    private final MenuMasterService menuService;
    private final ObjectMapper mapper = new ObjectMapper();

    public MaintenanceService(MaintenanceRepository repository, MenuMasterService menuService) {
        this.repository = repository;
        this.menuService = menuService;
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public Maintenance addData(String actions, String statuses, String path, MaintenanceRequest request) throws JsonProcessingException {
        log.info("Entering method addData on class " + MaintenanceService.class.getName() + " at " + System.currentTimeMillis());
        MenuMaster menu = menuService.getMenuByPath(path);
        String totalDataByMenu = String.valueOf(repository.countByMenuMaster(menu));
        String primaryCode = CommonUtil.generatePrimaryCode(CommonUtil.action(actions).toString(), menu.getMenuName(), totalDataByMenu);
        String refNum = CommonUtil.generateReferenceNumber(menu.getMenuName());
        Maintenance maintenance = MaintenanceInvocation.convert(request, menu, primaryCode, refNum, actions, statuses);
        repository.save(maintenance);
        log.info("Leaving method addData on class " + MaintenanceService.class.getName() + " at " + System.currentTimeMillis());
        log.info(mapper.writeValueAsString(maintenance));
        return maintenance;
    }
}
