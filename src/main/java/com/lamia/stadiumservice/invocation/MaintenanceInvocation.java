package com.lamia.stadiumservice.invocation;

import com.lamia.stadiumservice.model.Maintenance;
import com.lamia.stadiumservice.model.MenuMaster;
import com.lamia.stadiumservice.payload.request.MaintenanceRequest;
import com.lamia.stadiumservice.payload.response.MaintenanceResponse;
import com.lamia.stadiumservice.util.CommonUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class MaintenanceInvocation implements Serializable {

    public static Maintenance convert(MaintenanceRequest request, MenuMaster menu, String primaryCode, String refNum, String action, String status) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(UUID.randomUUID());
        maintenance.setOldValue(request.getOldValue());
        maintenance.setNewValue(request.getNewValue());
        maintenance.setPrimaryId(request.getPrimaryId());
        maintenance.setPrimaryCode(primaryCode);
        maintenance.setReferenceNumber(refNum);
        maintenance.setAction(CommonUtil.action(action));
        maintenance.setStatus(CommonUtil.status(status));
        maintenance.setLastActionTime(LocalDateTime.now());
        maintenance.setMenuMaster(menu);
        return maintenance;
    }

    public static MaintenanceResponse convert(Maintenance maintenance) {
        MaintenanceResponse response = new MaintenanceResponse();
        response.setMaintenanceId(maintenance.getMaintenanceId());
        response.setOldValue(maintenance.getOldValue());
        response.setNewValue(maintenance.getNewValue());
        response.setPrimaryId(maintenance.getPrimaryId());
        response.setPrimaryCode(maintenance.getPrimaryCode());
        response.setReferenceNumber(maintenance.getReferenceNumber());
        response.setAction(maintenance.getAction().toString());
        response.setStatus(maintenance.getStatus().toString());
        response.setLastActionTime(maintenance.getLastActionTime());
        response.setMenuMasterId(maintenance.getMenuMaster().getMenuMasterId());
        return response;
    }
}
