package com.lamia.stadiumservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lamia.stadiumservice.invocation.MaintenanceInvocation;
import com.lamia.stadiumservice.model.Maintenance;
import com.lamia.stadiumservice.model.Type;
import com.lamia.stadiumservice.payload.CommonResponse;
import com.lamia.stadiumservice.payload.ErrorMessage;
import com.lamia.stadiumservice.payload.ErrorSchema;
import com.lamia.stadiumservice.payload.request.MaintenanceRequest;
import com.lamia.stadiumservice.payload.request.StadiumRequest;
import com.lamia.stadiumservice.payload.request.TypeRequest;
import com.lamia.stadiumservice.repository.StadiumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StadiumService {

    private final Logger log = LoggerFactory.getLogger(StadiumService.class);
    private final StadiumRepository repository;
    private final MaintenanceService maintenanceService;
    private final MenuMasterService menuService;
    private final TypeService typeService;
    private final ObjectMapper mapper = new ObjectMapper();

    public StadiumService(StadiumRepository repository, MaintenanceService maintenanceService, MenuMasterService menuService, TypeService typeService) {
        this.repository = repository;
        this.maintenanceService = maintenanceService;
        this.menuService = menuService;
        this.typeService = typeService;
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public CommonResponse proposeStadium(String action, String status, String path, StadiumRequest request) throws JsonProcessingException {
        log.info("Entering method proposeStadium on class " + StadiumService.class.getName() + " at " + System.currentTimeMillis());
        CommonResponse response = new CommonResponse();

        Type type = typeService.getByIdAndStatus(request.getStadiumType().getTypeId());
        TypeRequest stadiumType = new TypeRequest();
        stadiumType.setTypeId(type.getTypeId());
        stadiumType.setTypeName(type.getTypeName());

        request.setStadiumId(UUID.randomUUID());
        request.setIsActive(true);
        request.setStadiumType(stadiumType);

        MaintenanceRequest maintenanceRequest = new MaintenanceRequest();
        maintenanceRequest.setPrimaryId(request.getStadiumId());
        maintenanceRequest.setOldValue(mapper.writeValueAsString(request));
        Maintenance maintenance = maintenanceService.addData(action, status, path, maintenanceRequest);

        ErrorSchema errorSchema = new ErrorSchema();
        ErrorMessage errorMessage = new ErrorMessage();
        errorSchema.setErrorCode("000000");
        errorMessage.setEnglish("SUCCESS");
        errorMessage.setBahasa("BERHASIL");
        errorSchema.setErrorMessage(errorMessage);

        response.setOutputSchema(MaintenanceInvocation.convert(maintenance));
        response.setErrorSchema(errorSchema);

        log.info("Leaving method proposeStadium on class " + StadiumService.class.getName() + " at " + System.currentTimeMillis());
        return response;
    }
}
