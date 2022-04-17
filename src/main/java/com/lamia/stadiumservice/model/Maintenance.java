package com.lamia.stadiumservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lamia.stadiumservice.model.audit.UserDateAudit;
import com.lamia.stadiumservice.util.ActionEnum;
import com.lamia.stadiumservice.util.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "maintenances")
@Proxy(lazy = false)
public class Maintenance extends UserDateAudit {

    @Id
    @Column(name = "maintenance_id")
    private UUID maintenanceId;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    @Column(name = "primary_id", length = 32, nullable = false)
    private UUID primaryId;

    @Column(name = "primary_code", length = 32, nullable = false)
    private String primaryCode;

    @Column(name = "reference_number", length = 32, nullable = false)
    private String referenceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private ActionEnum action;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "last_action_time")
    private LocalDateTime lastActionTime;

    @Column(name ="reject_reason")
    private String rejectReason;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_master_id", nullable = false)
    @JsonIgnore
    private MenuMaster menuMaster;
}
